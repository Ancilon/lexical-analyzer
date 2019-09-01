package br.sc.compilador.control;

import br.sc.compilador.Compilador;
import br.sc.compilador.util.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Classe para controle da tela do Compilador, executando todos os tipos de
 * controle de tela e regras de negócio.
 *
 * @author uniaodk <uniaodk@gmail.com>
 */
public class CompiladorControl {

    public static final int YES = 0;
    public static final int NO = 1;
    public static final int CANCEL = 2;

    private final Compilador compilador;
    private String codigoInicial, textEdit;
    private File arquivo;

    public CompiladorControl(Compilador compilador) {
        this.compilador = compilador;
        this.codigoInicial = "";
        this.arquivo = new File();
        arquivo.addFilter("aae", "aae");
        arquivo.getFileChooser().setCurrentDirectory(new java.io.File(File.DEFAULT));
    }

    public boolean isCodeEdited() {
        return !compilador.getTextEdicao().getText().equals(codigoInicial);
    }

    public int getOptionToSave() {
        return JOptionPane.showConfirmDialog(compilador,
                "Deseja salvar a edição realizada no arquivo",
                "Salvar", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public String getNameFileWindow() {
        return isLoadFile() ? compilador.getTitle().split(" - ")[1] : "";
    }

    public boolean isLoadFile() {
        return compilador.getTitle().split(" - ").length > 1;
    }

    public void setNameFileWindow() {
        String[] split = arquivo.getPath().split(File.OS);
        compilador.setTitle("Compilador - " + Arrays.asList(split).stream()
                .filter(word -> word.contains(".aae"))
                .findFirst().get());
    }

    public void newFile() {
        codigoInicial = "";
        compilador.setTitle("Compilador");
        cleanTextArea();
    }

    public void loadFile(String path) {
        cleanTextArea();
        setNameFileWindow();
        compilador.getTextEdicao().setText(getFileOpen(path));
    }

    public String getFileOpen(String path) {
        try {
            codigoInicial = arquivo.getImport(path, File.UTF_8);
            return codigoInicial;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(compilador,
                    "O arquivo não existe!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    public String getPathFile() {
        return arquivo.pathOpenFile();
    }

    public void saveFile() {
        try {
            arquivo.saveFile(compilador.getTextEdicao().getText(),
                    arquivo.getPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(compilador,
                    "Problema com o arquivo!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveWithFile() {
        try {
            arquivo.saveFile(compilador.getTextEdicao().getText(),
                    arquivo.pathSaveFile());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(compilador,
                    "Problema com o arquivo!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cleanTextArea() {
        compilador.getTextCompilacao().setText("");
        compilador.getTextEdicao().setText("");
    }

    public void copyText() {
        textEdit = compilador.getTextEdicao().getSelectedText() == null ?
                "" : compilador.getTextEdicao().getSelectedText();
    }

    public void pastText() {
        int position = compilador.getTextEdicao().getCaretPosition();
        int size = compilador.getTextEdicao().getText().length();
        String begin = compilador.getTextEdicao().getText().substring(0, position);
        String end = compilador.getTextEdicao().getText().substring(position, size);
        compilador.getTextEdicao().setText(begin + textEdit + end);
    }

    public void cutText() {
        copyText();
        int position = compilador.getTextEdicao().getCaretPosition();
        int size = compilador.getTextEdicao().getText().length();
        System.out.println(position);
        String begin = compilador.getTextEdicao().getText()
                .substring(0, position - textEdit.length());
        String end = compilador.getTextEdicao().getText().substring(position, size);
        compilador.getTextEdicao().setText(begin + end);
    }

}
