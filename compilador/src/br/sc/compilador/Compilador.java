package br.sc.compilador;

import br.sc.compilador.component.TextLineNumber;
import br.sc.compilador.control.CompiladorControl;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.text.Element;

/**
 *
 * @author deco
 */
public class Compilador extends javax.swing.JFrame {

    CompiladorControl control;
    TextLineNumber tln;

    public Compilador() {
        initComponents();
        this.control = new CompiladorControl(this);
    }

    public JLabel getLab_informacao() {
        return lab_informacao;
    }

    public JMenu getMenu_arquivo() {
        return menu_arquivo;
    }

    public JMenuItem getMenu_arquivo_abrir() {
        return menu_arquivo_abrir;
    }

    public JMenuItem getMenu_arquivo_novo() {
        return menu_arquivo_novo;
    }

    public JMenuItem getMenu_arquivo_sair() {
        return menu_arquivo_sair;
    }

    public JMenuItem getMenu_arquivo_salvar() {
        return menu_arquivo_salvar;
    }

    public JMenuItem getMenu_arquivo_salvar_como() {
        return menu_arquivo_salvar_como;
    }

    public JMenu getMenu_compilacao() {
        return menu_compilacao;
    }

    public JMenuItem getMenu_compilacao_compilar() {
        return menu_compilacao_compilar;
    }

    public JMenuItem getMenu_compilacao_exec_comp() {
        return menu_compilacao_exec_comp;
    }

    public JMenuItem getMenu_compilacao_executar() {
        return menu_compilacao_executar;
    }

    public JMenu getMenu_edicao() {
        return menu_edicao;
    }

    public JMenuItem getMenu_edicao_colar() {
        return menu_edicao_colar;
    }

    public JMenuItem getMenu_edicao_copiar() {
        return menu_edicao_copiar;
    }

    public JMenuItem getMenu_edicao_recortar() {
        return menu_edicao_recortar;
    }

    public JMenuBar getMenu_principal() {
        return menu_principal;
    }

    public JTextPane getTextCompilacao() {
        return text_compilacao;
    }

    public JTextPane getTextEdicao() {
        return text_edicao;
    }

    public JScrollPane getScroll_pane_compilacao() {
        return scroll_pane_compilacao;
    }

    public JScrollPane getScroll_pane_edicao() {
        return scroll_pane_edicao;
    }

    public JSeparator getSeparador() {
        return separador;
    }

    @Override
    public void dispose() {
        int option = CompiladorControl.YES;
        if (control.isCodeEdited()) {
            option = control.getOptionToSave();
            if (option == CompiladorControl.YES && !control.isLoadFile()) {
                control.saveWithFile();
            } else if (option == CompiladorControl.YES) {
                control.saveFile();
            }
        }
        if (option != CompiladorControl.CANCEL) {
            super.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_pane_edicao = new javax.swing.JScrollPane();
        text_edicao = new javax.swing.JTextPane();
        separador = new javax.swing.JSeparator();
        scroll_pane_compilacao = new javax.swing.JScrollPane();
        text_compilacao = new javax.swing.JTextPane();
        lab_informacao = new javax.swing.JLabel();
        toolbar = new javax.swing.JToolBar();
        toolbar_novo = new javax.swing.JButton();
        toolbar_abrir = new javax.swing.JButton();
        toolbar_salvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        toolbar_recortar = new javax.swing.JButton();
        toolbar_copiar = new javax.swing.JButton();
        toolbar_colar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        toolbar_compilar = new javax.swing.JButton();
        toolbar_executar = new javax.swing.JButton();
        toolbar_exec_comp = new javax.swing.JButton();
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

        text_edicao.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                text_edicaoCaretUpdate(evt);
            }
        });
        scroll_pane_edicao.setViewportView(text_edicao);
        tln = new TextLineNumber(text_edicao);
        scroll_pane_edicao.setRowHeaderView(tln);

        text_compilacao.setEditable(false);
        scroll_pane_compilacao.setViewportView(text_compilacao);

        lab_informacao.setText("Linha: 0, Coluna: 0");

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        toolbar_novo.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/new_file.png")); // NOI18N
        toolbar_novo.setFocusable(false);
        toolbar_novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_novoActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_novo);

        toolbar_abrir.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/open_file.png")); // NOI18N
        toolbar_abrir.setFocusable(false);
        toolbar_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_abrirActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_abrir);

        toolbar_salvar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/save.png")); // NOI18N
        toolbar_salvar.setFocusable(false);
        toolbar_salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_salvarActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_salvar);
        toolbar.add(jSeparator1);

        toolbar_recortar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/cut.png")); // NOI18N
        toolbar_recortar.setFocusable(false);
        toolbar_recortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_recortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_recortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_recortarActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_recortar);

        toolbar_copiar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/copy.png")); // NOI18N
        toolbar_copiar.setFocusable(false);
        toolbar_copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_copiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_copiarActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_copiar);

        toolbar_colar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/paste.png")); // NOI18N
        toolbar_colar.setFocusable(false);
        toolbar_colar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_colar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_colar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_colarActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_colar);
        toolbar.add(jSeparator2);

        toolbar_compilar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/compile.png")); // NOI18N
        toolbar_compilar.setFocusable(false);
        toolbar_compilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_compilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolbar_compilarActionPerformed(evt);
            }
        });
        toolbar.add(toolbar_compilar);

        toolbar_executar.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/run.png")); // NOI18N
        toolbar_executar.setFocusable(false);
        toolbar_executar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_executar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(toolbar_executar);

        toolbar_exec_comp.setIcon(new javax.swing.ImageIcon("/home/deco/Documentos/codes/lexical_analyzer/compilador/img/run_compile.png")); // NOI18N
        toolbar_exec_comp.setFocusable(false);
        toolbar_exec_comp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolbar_exec_comp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(toolbar_exec_comp);

        menu_arquivo.setText("Arquivo");

        menu_arquivo_novo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_novo.setText("Novo");
        menu_arquivo_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_novoActionPerformed(evt);
            }
        });
        menu_arquivo.add(menu_arquivo_novo);

        menu_arquivo_abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_abrir.setText("Abrir");
        menu_arquivo_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_abrirActionPerformed(evt);
            }
        });
        menu_arquivo.add(menu_arquivo_abrir);

        menu_arquivo_salvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_salvar.setText("Salvar");
        menu_arquivo_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_salvarActionPerformed(evt);
            }
        });
        menu_arquivo.add(menu_arquivo_salvar);

        menu_arquivo_salvar_como.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_arquivo_salvar_como.setText("Salvar Como");
        menu_arquivo_salvar_como.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_arquivo_salvar_comoActionPerformed(evt);
            }
        });
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
        menu_edicao_recortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_edicao_recortarActionPerformed(evt);
            }
        });
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
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_pane_edicao, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_pane_compilacao, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_informacao)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_edicao_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edicao_copiarActionPerformed
        control.copyText();
    }//GEN-LAST:event_menu_edicao_copiarActionPerformed

    private void menu_edicao_colarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edicao_colarActionPerformed
        control.pastText();
    }//GEN-LAST:event_menu_edicao_colarActionPerformed

    private void menu_arquivo_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_sairActionPerformed
        dispose();
    }//GEN-LAST:event_menu_arquivo_sairActionPerformed

    private void menu_arquivo_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_abrirActionPerformed
        String path = control.getPathFile();
        int option = CompiladorControl.YES;
        if (control.isCodeEdited()) {
            option = control.getOptionToSave();
            if (option == CompiladorControl.YES && !control.isLoadFile()) {
                control.saveWithFile();
            } else if (option == CompiladorControl.YES) {
                control.saveFile();
            }
        }
        if (option != CompiladorControl.CANCEL && path != null) {
            control.loadFile(path);
        }
    }//GEN-LAST:event_menu_arquivo_abrirActionPerformed

    private void menu_arquivo_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_novoActionPerformed
        int option = CompiladorControl.YES;
        if (control.isCodeEdited()) {
            option = control.getOptionToSave();
            if (option == CompiladorControl.YES && !control.isLoadFile()) {
                control.saveWithFile();
            } else if (option == CompiladorControl.YES) {
                control.saveFile();
            }
        }
        if (option != CompiladorControl.CANCEL) {
            control.newFile();
        }
    }//GEN-LAST:event_menu_arquivo_novoActionPerformed

    private void menu_arquivo_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_salvarActionPerformed
        if (control.isLoadFile()) {
            control.saveFile();
        } else {
            menu_arquivo_salvar_comoActionPerformed(evt);
        }
    }//GEN-LAST:event_menu_arquivo_salvarActionPerformed

    private void menu_arquivo_salvar_comoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_arquivo_salvar_comoActionPerformed
        control.saveWithFile();
        control.setNameFileWindow();
    }//GEN-LAST:event_menu_arquivo_salvar_comoActionPerformed

    private void text_edicaoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_text_edicaoCaretUpdate
        int pos = text_edicao.getCaretPosition();
        Element map = text_edicao.getDocument().getDefaultRootElement();
        int row = map.getElementIndex(pos);
        Element lineElem = map.getElement(row);
        int col = pos - lineElem.getStartOffset();
        lab_informacao.setText("Linha: " + row + ", Column: " + col);
    }//GEN-LAST:event_text_edicaoCaretUpdate

    private void menu_edicao_recortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edicao_recortarActionPerformed
        control.cutText();
    }//GEN-LAST:event_menu_edicao_recortarActionPerformed

    private void toolbar_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_novoActionPerformed
        menu_arquivo_novoActionPerformed(evt);
    }//GEN-LAST:event_toolbar_novoActionPerformed

    private void toolbar_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_abrirActionPerformed
        menu_arquivo_abrirActionPerformed(evt);
    }//GEN-LAST:event_toolbar_abrirActionPerformed

    private void toolbar_recortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_recortarActionPerformed
        menu_edicao_recortarActionPerformed(evt);
    }//GEN-LAST:event_toolbar_recortarActionPerformed

    private void toolbar_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_salvarActionPerformed
        menu_arquivo_salvarActionPerformed(evt);
    }//GEN-LAST:event_toolbar_salvarActionPerformed

    private void toolbar_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_copiarActionPerformed
        menu_edicao_copiarActionPerformed(evt);
    }//GEN-LAST:event_toolbar_copiarActionPerformed

    private void toolbar_colarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_colarActionPerformed
        menu_edicao_colarActionPerformed(evt);
    }//GEN-LAST:event_toolbar_colarActionPerformed

    private void toolbar_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolbar_compilarActionPerformed
       
    }//GEN-LAST:event_toolbar_compilarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
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
    private javax.swing.JScrollPane scroll_pane_compilacao;
    private javax.swing.JScrollPane scroll_pane_edicao;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextPane text_compilacao;
    private javax.swing.JTextPane text_edicao;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JButton toolbar_abrir;
    private javax.swing.JButton toolbar_colar;
    private javax.swing.JButton toolbar_compilar;
    private javax.swing.JButton toolbar_copiar;
    private javax.swing.JButton toolbar_exec_comp;
    private javax.swing.JButton toolbar_executar;
    private javax.swing.JButton toolbar_novo;
    private javax.swing.JButton toolbar_recortar;
    private javax.swing.JButton toolbar_salvar;
    // End of variables declaration//GEN-END:variables
}
