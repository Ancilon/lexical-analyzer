package teste4.compilador.src.br.sc.compilador;

import br.sc.compilador.component.TextLineNumber;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import teste4.Lexico;
import teste4.compilador.src.br.sc.compilador.control.CompiladorControl;



/**
 *
 * @author deco
 */
public class Compilador extends javax.swing.JFrame {
    
    CompiladorControl control;
    private String EnderecoTemporario;

    public Compilador() {
        initComponents();
        this.control = new CompiladorControl(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_pane_edicao = new javax.swing.JScrollPane();
        pane_edicao = new javax.swing.JTextPane();
        separador = new javax.swing.JSeparator();
        scroll_pane_compilacao = new javax.swing.JScrollPane();
        pane_compilacao = new javax.swing.JTextPane();
        lab_informacao = new javax.swing.JLabel();
        menu_principal = new javax.swing.JMenuBar();
        menu_arquivo = new javax.swing.JMenu();
        menu_arquivo_novo = new javax.swing.JMenuItem();
        menu_arquivo_abrir = new javax.swing.JMenuItem();
        menu_arquivo_salvar = new javax.swing.JMenuItem();
        menu_arquivo_salvar_como = new javax.swing.JMenuItem();
        menu_arquivo_sair = new javax.swing.JMenuItem();
        menu_edicao = new javax.swing.JMenu();
        menu_edicao_copiar = new javax.swing.JMenuItem();
        menu_edicao_recortar = new javax.swing.JMenuItem();
        menu_edicao_colar = new javax.swing.JMenuItem();
        menu_compilacao = new javax.swing.JMenu();
        menu_compilacao_compilar = new javax.swing.JMenuItem();
        menu_compilacao_executar = new javax.swing.JMenuItem();
        menu_compilacao_exec_comp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");

        scroll_pane_edicao.setViewportView(pane_edicao);
        TextLineNumber tln = new TextLineNumber(pane_edicao);
        scroll_pane_edicao.setRowHeaderView(tln);

        pane_compilacao.setEditable(false);
        scroll_pane_compilacao.setViewportView(pane_compilacao);

        lab_informacao.setText("Linha: , Coluna:");

        menu_arquivo.setText("Arquivo");

        menu_arquivo_novo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_novo.setText("Novo");
        menu_arquivo.add(menu_arquivo_novo);

        menu_arquivo_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_abrir.setText("Abrir");
        menu_arquivo.add(menu_arquivo_abrir);

        menu_arquivo_salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_salvar.setText("Salvar");
        menu_arquivo.add(menu_arquivo_salvar);

        menu_arquivo_salvar_como.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_salvar_como.setText("Salvar Como");
        menu_arquivo.add(menu_arquivo_salvar_como);

        menu_arquivo_sair.setText("Sair");
        menu_arquivo_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_sairActionPerformed(evt);
            }
        });
        menu_arquivo.add(menu_arquivo_sair);

        menu_principal.add(menu_arquivo);

        menu_edicao.setText("Edição");

        menu_edicao_copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menu_edicao_copiar.setText("Copiar");
        menu_edicao_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_edicao_copiarActionPerformed(evt);
            }
        });
        menu_edicao.add(menu_edicao_copiar);

        menu_edicao_recortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menu_edicao_recortar.setText("Recortar");
        menu_edicao.add(menu_edicao_recortar);

        menu_edicao_colar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menu_edicao_colar.setText("Colar");
        menu_edicao_colar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_edicao_colarActionPerformed(evt);
            }
        });
        menu_edicao.add(menu_edicao_colar);

        menu_principal.add(menu_edicao);

        menu_compilacao.setText("Compilação");

        menu_compilacao_compilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        menu_compilacao_compilar.setText("Compilar");
        menu_compilacao_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_compilacao_compilarActionPerformed(evt);
            }
        });
        menu_compilacao.add(menu_compilacao_compilar);

        menu_compilacao_executar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        menu_compilacao_executar.setText("Executar");
        menu_compilacao.add(menu_compilacao_executar);

        menu_compilacao_exec_comp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        menu_compilacao_exec_comp.setText("Compilar/Executar");
        menu_compilacao.add(menu_compilacao_exec_comp);

        menu_principal.add(menu_compilacao);

        setJMenuBar(menu_principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador)
                    .addComponent(scroll_pane_compilacao)
                    .addComponent(scroll_pane_edicao)
                    .addComponent(lab_informacao, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_pane_edicao, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_pane_compilacao, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_informacao)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_edicao_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edicao_copiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_edicao_copiarActionPerformed

    private void menu_edicao_colarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edicao_colarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_edicao_colarActionPerformed

    private void menu_arquivo_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_sairActionPerformed
        dispose();
    }//GEN-LAST:event_menu_arquivo_sairActionPerformed

    private void menu_compilacao_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_compilacao_compilarActionPerformed
        try {      
            AnaliseLexSomente();
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_compilacao_compilarActionPerformed
    public String getEnderecoTemporario(){
        return EnderecoTemporario;
    }
    
    
    private void AnaliseLexSomente() throws IOException{
                
    EnderecoTemporario =  System.getProperty("java.io.tmpdir")+"temp.txt";
    File arquivo = new File(EnderecoTemporario);  
    FileWriter fw = new FileWriter(arquivo);  
    BufferedWriter bw = new BufferedWriter(fw);
    System.out.println("Foi analisado");
    System.out.println(pane_edicao.getText());
    bw.write(pane_edicao.getText());  
    bw.flush();  
    bw.close(); 
                                
    String nomeArq = new String(EnderecoTemporario);
    Lexico lex = new Lexico(new FileInputStream(nomeArq));
    String args[] = null;
    try {
        String analise = lex.processa(); //processamento dos lexemas 
        System.out.println("Esta é a analise:");
        System.out.println(analise);
        System.out.println("Fim da analise");
        pane_compilacao.setText(analise);

    }

        catch (Exception e)
    {
    pane_compilacao.setText("Analise Sintaxica NOT OK");
    System.out.println("Erro de Token.");

    e.printStackTrace();
        }
    catch (Error e)
    {
        System.out.println(e.getMessage());//Mensagem de erro léxico (em ingles) mostrando linha e coluna
    }     
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lab_informacao;
    private javax.swing.JMenu menu_arquivo;
    private javax.swing.JMenuItem menu_arquivo_abrir;
    private javax.swing.JMenuItem menu_arquivo_novo;
    private javax.swing.JMenuItem menu_arquivo_sair;
    private javax.swing.JMenuItem menu_arquivo_salvar;
    private javax.swing.JMenuItem menu_arquivo_salvar_como;
    private javax.swing.JMenu menu_compilacao;
    private javax.swing.JMenuItem menu_compilacao_compilar;
    private javax.swing.JMenuItem menu_compilacao_exec_comp;
    private javax.swing.JMenuItem menu_compilacao_executar;
    private javax.swing.JMenu menu_edicao;
    private javax.swing.JMenuItem menu_edicao_colar;
    private javax.swing.JMenuItem menu_edicao_copiar;
    private javax.swing.JMenuItem menu_edicao_recortar;
    private javax.swing.JMenuBar menu_principal;
    private javax.swing.JTextPane pane_compilacao;
    private javax.swing.JTextPane pane_edicao;
    private javax.swing.JScrollPane scroll_pane_compilacao;
    private javax.swing.JScrollPane scroll_pane_edicao;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
