package Analizador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;


public class Proyecto extends javax.swing.JFrame {
    String ruta = "C:/Users/Public/archivo.txt";
    File archivo = new File(ruta);
    BufferedWriter bw;
    
    String expresion;
    String Lenguaje="";
    String TD = "(void|double|string|int|float|char|short|long|boolean)";
    String B = "(double|String|Int|Float|Char|Short|Long|Boolean)";
    String ID = "[A-Z]([A-Za-z]|_|-|(\\d))*";
    String OA = "(\\+|\\-|\\*|\\/)";
    String AS = "(\\=)"; 
    String SEP = "(;|,)";
    String CNE = "((\\d)+)";
    String CNPF = "((\\d)+(\\.)(\\d)+)";
    String DEL ="(\\(|\\)|\\{|\\})";
    String regexp = "(void|double|string|int|float|char|short|long|boolean)[A-Z]([A-Za-z]|_|-|(\\d))+[//(][//)]";
    //"[A-Z][A-Za-z|_|(\\d)]*(\\s)(\\=)(\\s)(([(A-Z)(\\d)*(\\s)]*|[(\\d)+(\\.d+)*(\\s)]*)(\\+|\\-|\\*|\\/)*)*";
    String ERLXTD="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*([v]|[d]|[s]|[i]|[f]|[c]|[s]|[l]|[b])([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXID="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[A-Z](@|λ|\\[|\\]|(|)|\\+|\\-|\\*|\\/|\\;|\\“|\\{|\\}|#|\\=|\\.)*([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/|\\[|\\]|@)*"; 
    String ERLXOA="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\+|\\-|\\*|\\/)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXAS="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\=)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXSEP="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(;|,)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXCNE="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXCNPF="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*\\.([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXDEL="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\(|\\)|\\{|\\})([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
//+ "(void|double|String|Int|Float|Char|Short|Long|Boolean)(\\s)[A-Z]([A-Za-z]|_|-|(\\d))+[//(][//)]";
//"((double|String|Int|Float|Char|Short|Long|Boolean) λ [A-Z]([A-Za-z]|_|-|(\\d))+),\n" +
//"λ ((double|String|Int|Float|Char|Short|Long|Boolean) λ [A-Z]([A-Za-z]|_|-|(\\d))+)*";
    
    public Proyecto() {
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablavts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavts2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        btn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablavts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token", "Lexema", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tablavts);

        jLabel1.setText("Tabla de Simbolos");

        tablavts2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Token de error", "Lexema", "Linea", "Descripcion"
            }
        ));
        jScrollPane2.setViewportView(tablavts2);

        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane3.setViewportView(txt1);

        btn1.setText("Comprobar");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tabla de errores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
       try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            System.out.println("hola");
        }else {
            bw = new BufferedWriter(new FileWriter(archivo));
            System.out.println("no hola");
        }
        this.expresion = txt1.getText();
        Boolean verdad=true;
        int auxiliando=0,p=1,r=1;
        int aid=1,aoa=1,aas=1,asep=1,acne=1,acnpf=1,adel=1,atd=1;
        
            DefaultTableModel model = new DefaultTableModel();
            DefaultTableModel model2 = new DefaultTableModel();
            model.addColumn("Token");
            model.addColumn("Lexema");
            model.addColumn("Tipo");
            tablavts.setModel(model);
            
            model2.addColumn("Token de error");
            model2.addColumn("Lexema");
            model2.addColumn("Linea");
            model2.addColumn("Descripcion");
            tablavts2.setModel(model2);
            
            String[] datos = new String[3]; 
            String[] guardar = new String[100];
            String[] datos2 = new String[4];
           
          
           StringTokenizer tokens=new StringTokenizer(expresion," \n\t",true);        
                while(true){
                r=1;    
                if(tokens.hasMoreTokens()){
                   String a=tokens.nextToken();
                    int aid2=1,aoa2=1,aas2=1,asep2=1,acne2=1,acnpf2=1,adel2=1,atd2=1,cambiar=1;
                    
                    for (int j = 0; j < guardar.length; j++) {
                        if(a.equals(guardar[j])){                          
                            cambiar=0;
                            r=0; 
                            break;
                        }else{
                            if(guardar[j]!=null){
                            if(verdad==guardar[j].matches(TD)){ 
                                atd2++;
                            }else if(verdad==guardar[j].matches(ID)){
                                aid2++;
                            }else if(verdad==guardar[j].matches(OA)){     
                                aoa2++;
                            }else if(verdad==guardar[j].matches(AS)){  
                                aas2++;
                            }else if(verdad==guardar[j].matches(SEP)){   
                                asep2++;
                            }else if(verdad==guardar[j].matches(CNE)){ 
                                acne2++;
                            }else if(verdad==guardar[j].matches(CNPF)){
                                acnpf2++;
                            }else if(verdad==guardar[j].matches(DEL)){
                                adel2++;
                            }else if(verdad==guardar[j].matches(ERLXTD)){
                                atd2++;
                            }else if(verdad==guardar[j].matches(ERLXID)){
                                aid2++;
                            }else if(verdad==guardar[j].matches(ERLXOA)){     
                                aoa2++;
                            }else if(verdad==guardar[j].matches(ERLXAS)){  
                                aas2++;
                            }else if(verdad==guardar[j].matches(ERLXSEP)){   
                                asep2++;
                            }else if(verdad==guardar[j].matches(ERLXCNPF)){
                                acnpf2++;
                            }else if(verdad==guardar[j].matches(ERLXCNE)){ 
                                acne2++;
                            }else if(verdad==guardar[j].matches(ERLXDEL)){
                                adel2++;
                            }
                             cambiar=1; 
                             
                        }}
                    }
                    
                    if(a.equals("\n")){
                        p++;
                        bw.write("\n");
                        r=0;
                    }else if(a.equals(" ") || a.equals("\t")){
                        r=0;
                    }
                   
                if(verdad==a.matches(TD)){ 
                    if(cambiar==0){
                        bw.write("TD"+atd2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="TD"+atd;
                        bw.write("TD"+atd+" ");                         
                        atd++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                    }
                    r=0;
                }else if(verdad==a.matches(ID)){
                     if(cambiar==0){
                        bw.write("ID"+aid2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="ID"+aid;
                        bw.write("ID"+aid+" ");
                        aid++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                     }
                     r=0;  
                }else if(verdad==a.matches(OA)){
                     if(cambiar==0){
                        bw.write("OA"+aoa2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="OA"+aoa;
                        bw.write("OA"+aoa+" ");
                        aoa++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                     }  
                     r=0;  
                }else if(verdad==a.matches(AS)){
                     if(cambiar==0){
                        bw.write("AS"+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="AS";
                        bw.write("AS"+" ");
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                     }    
                     r=0;  
                }else if(verdad==a.matches(SEP)){
                     if(cambiar==0){
                        bw.write("SEP"+asep2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="SEP"+asep;
                        bw.write("SEP"+asep+" ");   
                        asep++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                     }  
                     r=0;  
                }else if(verdad==a.matches(CNE)){
                     if(cambiar==0){
                        bw.write("CNE"+acne2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="CNE"+acne;
                        bw.write("CNE"+acne+" ");
                        acne++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++; 
                     }    
                     r=0;  
                }else if(verdad==a.matches(CNPF)){
                     if(cambiar==0){
                        bw.write("CNE"+acnpf2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="CNPF"+acnpf;
                        bw.write("CNPE"+acnpf+" ");
                        acnpf++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++; 
                     }    
                     r=0;  
                }else if(verdad==a.matches(DEL)){
                     if(cambiar==0){
                        bw.write("DEL"+adel2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="DEL"+adel;
                        bw.write("DEL"+adel+" ");
                        adel++;
                        guardar[auxiliando]=datos[1];
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                     }  
                     r=0;  
                }else if(verdad==a.matches(ERLXTD) && r==1) { 
                   datos[0]="ERLXTD"+atd;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXTD"+atd;   
                   bw.write("ERLXTD"+atd+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el tipo \nde dato";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   atd++;               
                   r=0;
               }else if(verdad==a.matches(ERLXID) && r==1) {
                   datos[0]="ERLXID"+aid;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXID"+aid;   
                   bw.write("ERLXID"+aid+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el identificador";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   aid++;                  
                   r=0;
               }else if(verdad==a.matches(ERLXOA) && r==1) {
                   datos[0]="ERLXOA"+aoa;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXOA"+aoa;      
                   bw.write("ERLXOA"+aoa+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el operador";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   aoa++; 
                   r=0;
               }else if(verdad==a.matches(ERLXAS) && r==1) {
                   datos[0]="ERLXAS"+aas;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXAS";  
                   bw.write("ERLXAS"+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto la asignacion";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);   
                   r=0;
               }else if(verdad==a.matches(ERLXSEP) && r==1) {
                   datos[0]="ERLXSEP"+asep;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXSEP"+asep;      
                   bw.write("ERLXSEP"+asep+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el misceláneo";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   asep++;
                   r=0;
               }else if(verdad==a.matches(ERLXCNPF) && r==1) {
                   datos[0]="ERLXCNPF"+acnpf;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXCNPF"+acnpf;       
                   bw.write("ERLXCNPF"+acnpf+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el punto flotante";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   acnpf++;             
                   r=0;
               }else if(verdad==a.matches(ERLXCNE) && r==1) {
                   datos[0]="ERLXCNE"+acne;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXCNE"+acne;          
                   bw.write("ERLXCNE"+acne+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecta la constante entera";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   acne++;  
                   r=0;
               }else if(verdad==a.matches(ERLXDEL) && r==1) {
                   datos[0]="ERLXDEL"+adel;
                   datos[1]=a;
                   guardar[auxiliando]=datos[1];
                   model.addRow(datos);
                   tablavts.setModel(model);
                   auxiliando++;
                   datos2[1]=a;
                   datos2[0]="ERLXDEL"+adel;   
                   bw.write("ERLXDEL"+adel+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Incorrecto el delimitador";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
                   adel++;    
                   r=0;
               }else if(r==1){
                    System.out.println(a);
                   datos2[1]=a;
                   datos2[0]="DESCONOCIDO";   
                  // bw.write("DESCONOCIDO"+" ");
                   datos2[2]=String.valueOf(p);
                   datos2[3]="Error aun no contemplado";
                   model2.addRow(datos2);
                   tablavts2.setModel(model2);
               }
                for (int i = 0; i < 10; i++) {
            System.out.println(guardar[i]);
            }
               
            }else{
                    break;
                 }

            }
            bw.close();
       }catch(Exception e){
                System.out.println(e);
                }
        
  
    }//GEN-LAST:event_btn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablavts;
    private javax.swing.JTable tablavts2;
    private javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
}
