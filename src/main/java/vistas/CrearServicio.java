package vistas;

import controladores.ClienteControlador;
import dominio.Categoria;
import dominio.Dispositivo;
import dominio.ItemMenu;
import dominio.Pedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CrearServicio extends javax.swing.JFrame implements VistaCliente {

    private JPanel pnlConfirmacion;
    private JButton btnConfirmarLectura;

    private ClienteControlador clienteControlador;

    public CrearServicio(Dispositivo dispositivo) {
        initComponents();

        this.clienteControlador = new ClienteControlador(this, dispositivo);

        clienteControlador.mostrarCategorias();

        listCategorias.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Categoria seleccionada = listCategorias.getSelectedValue();
                if (seleccionada != null) {
                    clienteControlador.cargarItemsDeCategoria(seleccionada);
                }
            }
        });

        initConfirmacionPanel();
    }
    
    private void initConfirmacionPanel() {
        pnlConfirmacion = new JPanel(new BorderLayout(10, 10));
        pnlConfirmacion.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pnlConfirmacion.setBackground(Color.WHITE);
        pnlConfirmacion.setPreferredSize(new Dimension(300, 120));

        JLabel lbl = new JLabel(
                "<html><center>He leído la información<br/>de pago.</center></html>",
                SwingConstants.CENTER
        );
        btnConfirmarLectura = new JButton("OK");

        pnlConfirmacion.add(lbl, BorderLayout.CENTER);
        pnlConfirmacion.add(btnConfirmarLectura, BorderLayout.SOUTH);

        // 3) agrego el glass panel y lo oculto
        JComponent glass = (JComponent) getRootPane().getGlassPane();
        glass.setLayout(new GridBagLayout());            
        glass.add(pnlConfirmacion, new GridBagConstraints());
        glass.setVisible(false);                         

        //cuando toco ok, se cierra el panel
        btnConfirmarLectura.addActionListener(e -> {
            glass.setVisible(false);
            clienteControlador.logoutYLimpieza();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentarioPedido = new javax.swing.JTextArea();
        btnAgregarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnConfirmarPedido = new javax.swing.JButton();
        btnFinalizarServicio = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        txtMontoTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblMsjSalida = new javax.swing.JLabel();
        lblMsjSalida2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificarse"));

        jLabel1.setText("Número Cliente:");

        jLabel2.setText("Contraseña:");

        btnLogin.setText("Aceptar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnLogin)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú"));

        jScrollPane1.setViewportView(listCategorias);

        listItems.setBorder(javax.swing.BorderFactory.createTitledBorder("Ítems:"));
        jScrollPane2.setViewportView(listItems);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentario"));

        txtComentarioPedido.setColumns(20);
        txtComentarioPedido.setRows(5);
        jScrollPane3.setViewportView(txtComentarioPedido);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnAgregarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPedido)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPedido)
                    .addComponent(btnEliminarPedido))
                .addGap(5, 5, 5))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos del Servicio"));

        btnConfirmarPedido.setText("Confirmar Pedidos");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarServicio.setText("Finalizar Servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ítem", "Comentario", "Estado", "Unidad", "Gestor", "Precio"
            }
        ));
        jScrollPane5.setViewportView(tblPedidos);

        txtMontoTotal.setText("0");

        jLabel3.setText("Monto total: $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnConfirmarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinalizarServicio)
                        .addGap(0, 482, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarPedido)
                    .addComponent(btnFinalizarServicio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensaje de sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMsjSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblMsjSalida2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblMsjSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsjSalida2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        agregarPedido();
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        eliminarPedido();
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        confirmarPedidos();
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed
        finalizarServicio();
    }//GEN-LAST:event_btnFinalizarServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblMsjSalida;
    private javax.swing.JLabel lblMsjSalida2;
    private javax.swing.JList<Categoria> listCategorias;
    private javax.swing.JList<ItemMenu> listItems;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextArea txtComentarioPedido;
    private javax.swing.JLabel txtMontoTotal;
    private javax.swing.JTextField txtNumeroCliente;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void login() {
        String numeroCliente = txtNumeroCliente.getText();
        String password = txtPassword.getText();
        clienteControlador.procesarLogin(numeroCliente, password);
    }

    private void agregarPedido() {
        clienteControlador.crearPedido(listItems.getSelectedValue(), txtComentarioPedido.getText());
    }

    @Override
    public void limpiarMensajeDeError() {
        lblMsjSalida.setText("");
    }

    @Override
    public void mostrarMensajeDeError(String mensaje) {
        lblMsjSalida.setText(mensaje);
    }

    @Override
    public void mostrarMensajePago(String mensaje) {
        lblMsjSalida.setText(mensaje);
    }

    @Override
    public void mostrarMensajeExitoso(String mensaje) {
        lblMsjSalida2.setText(mensaje);
    }

    @Override
    public void mostrarMensajeBienvenida(String nombreCompleto) {
        setTitle(nombreCompleto);
    }

    @Override
    public void cargarCategorias(Collection<Categoria> categorias) {
        DefaultListModel<Categoria> model = new DefaultListModel<>();

        for (Categoria cat : categorias) {
            model.addElement(cat);
        }
        listCategorias.setModel(model);
    }

    @Override
    public void mostrarItemsDeCategoria(Collection<ItemMenu> items) {
        DefaultListModel<ItemMenu> model = new DefaultListModel<>();
        for (ItemMenu item : items) {
            model.addElement(item);
        }
        listItems.setModel(model);
    }

    public ClienteControlador getClienteControlador() {
        return clienteControlador;
    }

    @Override
    public void mostrarPedidosDeServicio(ArrayList<Pedido> pedidos) {
        String[] columnas = {"Ítem", "Comentario", "Estado", "Unidad", "Gestor", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (Pedido p : pedidos) {
            String gestor = p.getGestorAsignado() != null
                    ? p.getGestorAsignado().getNombreCompleto()
                    : "-";
            Object[] fila = new Object[]{
                p.getItemMenu().getNombre(),
                p.getComentario(),
                p.getNombreEstado(),
                p.getItemMenu().getUnidadProcesadora().getNombre(),
                gestor,
                p.getItemMenu().getPrecioUnitario()
            };
            model.addRow(fila);
        }
        tblPedidos.setModel(model);
    }

    @Override
    public void mostrarInfoPago(String beneficio, double montoBeneficio, double montoAPagar) {
        txtMontoTotal.setText(String.format("%.2f", montoAPagar));
        //esto es porque swing renderiza dentro de un jlabel y no interpreta \n como salto de linea.
        String html = "<html>"
                + "Pago realizado con éxito.<br>"
                + "Beneficio: " + beneficio + "<br>"
                + "Monto beneficio: " + String.format("%.2f", montoBeneficio) + "<br>"
                + "Monto total: " + String.format("%.2f", montoAPagar)
                + "</html>";
        mostrarMensajePago(html);
    }

    private void eliminarPedido() {
        int pedidoSeleccionado = tblPedidos.getSelectedRow();
        clienteControlador.eliminarPedido(pedidoSeleccionado);

    }

    private void confirmarPedidos() {
        clienteControlador.confirmarPedidos();
    }

    private void finalizarServicio() {
        clienteControlador.finalizarServicio();
    }

    @Override
    public void solicitarConfirmacionLectura() {
        JComponent glass = (JComponent) getRootPane().getGlassPane();
        glass.setVisible(true);
    }

    @Override
    public void limpiarVistaDispositivo() {
        txtNumeroCliente.setText("");
        txtPassword.setText("");
        setTitle("Bienvenido a Pollomorfismo");
        listCategorias.clearSelection();
        listItems.setModel(new DefaultListModel<>());
        String[] columnas = {"Ítem", "Comentario", "Estado", "Unidad", "Gestor", "Precio"};
        tblPedidos.setModel(new DefaultTableModel(columnas, 0));
        txtMontoTotal.setText("0");
        lblMsjSalida.setText("");
        lblMsjSalida2.setText("");
        txtComentarioPedido.setText("");
    }

    @Override
    public void cargarMontoTotal(String datos) {
        txtMontoTotal.setText(datos);
    }

    

}
