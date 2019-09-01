package br.sc.compilador.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Ler arquivos e transforma em uma estrutura de facil manipulação.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class File {

    public static final String UTF_8 = "utf-8";
    public static final String WIND_1232 = "windows-1252";
    public static final String OS = System.getProperty("os.name").equals("Linux")
            ? "//" : "\\";
    public static final String PROJECT = System.getProperty("user.dir") + OS;
    public static final String DEFAULT = PROJECT + "default" + OS;

    private JFileChooser fileChooser;
    private String path;

    public File() {
        this.fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
    }

    /**
     * Transforma o arquivo selecionado em uma estrutura de leitura das linhas
     * do arquivo.
     *
     * @param path o caminho da localização do arquivo.
     * @param unicode o formato unicode que o arquivo esta formatado, para
     * evitar perdas de caracteres
     * @return retorna o arquivo lido na estrutura de Scanner, podendo ser
     * convertido depois para String através do método getText() ou tabela pelo
     * getTabke().
     * @throws FileNotFoundException lança uma excessão caso não encontre o
     * arquivo.
     */
    public Scanner getScanner(String path, String unicode)
            throws FileNotFoundException {
        return new Scanner(new InputStreamReader(new FileInputStream(path),
                Charset.forName(unicode).newEncoder().charset()));
    }

    /**
     * Transforma a estrutura Scanner em um texto corrido, conforme o arquivo
     * exportado.
     *
     * @param scanner a estrutura com os dados do arquivo.
     * @return o texto corrido dos dados do arquivo.
     */
    public String getText(Scanner scanner) {
        String line = "";
        while (scanner.hasNextLine()) {
            line += scanner.nextLine() + '\n';
        }
        return line;
    }

    /**
     * Transforma o arquivo de importação em formato de um texto corrido, ou
     * seja, string.
     *
     * @param path o caminho da localização do arquivo.
     * @param unicode o formato unicode que o arquivo esta formatado, para
     * evitar perdas de caracteres
     * @return o texto corrido dos dados do arquivo.
     * @throws FileNotFoundException lança uma excessão caso não encontre o
     * arquivo.
     */
    public String getImport(String path, String unicode)
            throws FileNotFoundException {
        Scanner scanner = getScanner(path, unicode);
        return getText(scanner);
    }

    public String getPath() {
        return path;
    }

    public File withPath(String path) {
        this.path = path;
        return this;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public File withFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
        return this;
    }

    /**
     * Adiciona filtros de visibilidade dos formatos de arquivo na seleção do
     * arquivo.
     *
     * @param formats uma lista de formatos de aqruivo que será visivel na
     * seleção;
     */
    public void addFilter(String... formats) {
        Arrays.asList(formats).forEach(format
                -> fileChooser.setFileFilter(new FileNameExtensionFilter("." + format, format)));
    }

    /**
     * Busca o caminho do arquivo para abrir através do componente JFileChooser.
     *
     * @return retorna o caminho do arquivo caso o usuário selecione a opção
     * open, caso contrário retorna um valor null.
     */
    public String pathOpenFile() {
        if (getOptionDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getPath();
            return path;
        }
        return null;
    }

    private final int YES = 0;

    /**
     * Busca o caminho do arquivo para salvar através do componente
     * JFileChooser.
     *
     * @return retorna o caminho do arquivo caso o usuário selecione a opção
     * save, caso contrário retorna um valor null.
     */
    public String pathSaveFile() {
        if (getSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            if (existFile(fileChooser.getSelectedFile().getPath())) {
                if (getOptionSubscibe() == YES) {
                    path = adjustSaveFile(fileChooser);
                    return path;
                }
            } else {
                path = adjustSaveFile(fileChooser);
                return path;
            }
        }
        return null;
    }

    private int getOptionSubscibe() {
        return JOptionPane.showConfirmDialog(fileChooser,
                "O arquivo já existe, deseja sobrescrever?",
                "AVISO", JOptionPane.YES_NO_OPTION);
    }

    public boolean existFile(String pathFile) {
        try ( BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Opção da escolha do usário na seleção para abrir arquivo ou pasta, as
     * opções se encontram na classe JFileChooser.
     *
     * @param fileChooser componente que iniciará a seleção de arquivo.
     * @return o valor da ação da escolha do usuário, ver a classe JFileChoose.
     */
    private int getOptionDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(fileChooser.getRootPane());
    }

    /**
     * Opção da escolha do usário na seleção para salvar arquivo, as opções se
     * encontram na classe JFileChooser.
     *
     * @param fileChooser componente que iniciará a seleção de arquivo.
     * @return o valor da ação da escolha do usuário, ver a classe JFileChoose.
     */
    private int getSaveDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(fileChooser.getRootPane());
    }

    /**
     * Ajustar o nome do arquivo para salvar conforme o formato do filtro do
     * componente JFileChooser
     *
     * @param fileChooser componente de busca de pasta e arquivos.
     * @return o caminho para salvar o arquivo em formato de string.
     */
    private String adjustSaveFile(JFileChooser fileChooser) {
        String path = fileChooser.getSelectedFile().getPath();
        String format = fileChooser.getFileFilter().getDescription();
        return path.contains(format) ? path : path + format;
    }

    public void saveFile(String code, String pathFile) throws IOException {
        if (pathFile != null) {
            java.io.FileWriter writer = new java.io.FileWriter(new java.io.File(pathFile));
            writer.write(code);
            writer.close();
        } else {
            JOptionPane.showMessageDialog(fileChooser, "Arquivo não foi salvo!");
        }
    }

}
