package Analizador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;


public class Proyecto extends javax.swing.JFrame {
    String ruta = "archivoTokens.txt";
    File archivo = new File(ruta);
    BufferedWriter bw;
    String ruta2 = "C:/Users/Public/archivoOpti.txt";
    File archivo4 = new File(ruta2);
    BufferedWriter bwt;
    
    String expresion;
    String Lenguaje="";
    String TD = "(&Flotante&|&Doble&|&Largo&)";
    String ID = "@ER(\\d)*#";
    String OA = "(\\+|\\-|\\*|\\/)";
    String AS = "(\\=)"; 
    String SEP = "(;|,)";
    String CNE = "((\\d)+)";
    String CNPF = "((\\d)+(\\.)(\\d)+)";
    String DEL ="(\\(|\\)|\\{|\\}|;|,)";
    String regexp = "(void|double|string|int|float|char|short|long|boolean)[A-Z]([A-Za-z]|_|-|(\\d))+[//(][//)]";
    
    //"[A-Z][A-Za-z|_|(\\d)]*(\\s)(\\=)(\\s)(([(A-Z)(\\d)*(\\s)]*|[(\\d)+(\\.d+)*(\\s)]*)(\\+|\\-|\\*|\\/)*)*";
    String ERLXTD="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[#]|[\"]|[.]|[_])*([@]|[8]|[h])([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    
    String ERLXID="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[A-Z](@|λ|\\[|\\]|(|)|\\+|\\-|\\*|\\/|\\;|\\“|\\{|\\}|#|\\=|\\.)*([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/|\\[|\\]|@)*"; 
    String ERLXOA="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\+|\\-|\\*|\\/)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXAS="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\=)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXSEP="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(;|,)([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXCNE="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXCNPF="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*\\.([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*[0-9]+([A-Z]|[a-z]|_|-|[0-9]|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
    String ERLXDEL="([a]|[e]|[g]|[h]|[j]|[k]|[m-r]|[t]|[u]|[w-z]|[@]|[#]|[\"]|[.]|[_])*(\\(|\\)|\\{|\\})([A-Z]|[a-z]|_|-|(\\d)|.|\\(|\\)|\\{|\\}|#|\\=|\\s|\\*|\\-|\\_|\\+|\\/)*";
     String IGN = "while|==|!=|<=|>=|<|>";
     String IGNM ="&&|\\|\\|";
    
    public Proyecto() {
        
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablavts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavts2 = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizando");
        setBackground(new java.awt.Color(255, 51, 51));

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane3.setViewportView(txt1);

        jLabel6.setText("Entradas al Programa");

        btn1.setText("Verificar expresión");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(181, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Entrada del Programa", jPanel1);

        tablavts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Token", "Lexema"
            }
        ));
        jScrollPane1.setViewportView(tablavts);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabla de simbolos", jPanel2);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Tabla de errores", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        ArrayList<String> guardar3 = new ArrayList<String>(); //todos sin su numero de linea
        ArrayList<String> cadenas = new ArrayList<String>(); //as
        try{
            if(archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));

            }else {
                bw = new BufferedWriter(new FileWriter(archivo));

            }
            this.expresion = txt1.getText();
            Boolean verdad=true;
            int auxiliando=0,p=1,r=1,k=0,h=0,l=0,u=0,B=0,oa=5,as=5, v=0;

            int lex=1,aid=1,aoa=1,aas=1,asep=1,acne=1,acnpf=1,adel=1,atd=1,errsem=1,b=0,suma=0,suma2=0,unm=0,opre=1,oplb=1,whle=1;

            DefaultTableModel model = new DefaultTableModel();
            DefaultTableModel model2 = new DefaultTableModel();
            DefaultTableModel model3 = new DefaultTableModel();
            model.addColumn("Token");
            model.addColumn("Lexema");
            tablavts.setModel(model);

            model2.addColumn("Token de error");
            model2.addColumn("Lexema");
            model2.addColumn("Linea");
            model2.addColumn("Descripcion");
            tablavts2.setModel(model2);

            model3.addColumn("Lexema");
            model3.addColumn("Tipo");
            /*tablavtss.setModel(model3); */

            String[] datos = new String[3]; //primera tabla
            ArrayList<String> guardar = new ArrayList<String>(); //todos sin los que se repiten
            ArrayList<String> guardar2 = new ArrayList<String>(); //todos con su numero de linea

            ArrayList<String> guardar4 = new ArrayList<String>(); //los errores para que no se repitan la misma linea
            ArrayList<String> guardar5 = new ArrayList<String>(); //los declarados para que no se repitan en su tabla
            ArrayList<String> guardar6 = new ArrayList<String>(); //oa
            ArrayList<String> guardar7 = new ArrayList<String>(); //as
            ArrayList<String> guardar10 = new ArrayList<String>();

            String[] datos2 = new String[4]; //segunda tabla de declarados
            String[] datos3 = new String[2]; //errores

            int lolito=4;
            StringTokenizer tokens=new StringTokenizer(expresion," \n\t",true);
            while(true){
                r=1;
                if(tokens.hasMoreTokens()){
                    String a=tokens.nextToken();

                    if(a.equals("\n") || a.equals("\t") || a.equals(" ")){

                    }else{

                        guardar2.add(a+p);
                        guardar3.add(a);

                        if(guardar3.size()>2){
                            if(!guardar3.get(guardar3.size()-2).matches(OA)){
                                guardar6.clear();
                            }
                        }

                    }
                    if(!a.equals(" ") && !a.equals("\t") && !a.equals("\n")){
                        if(verdad==a.matches(TD)){
                            lolito=1;
                        }else if(verdad==a.matches(ID) && lolito==1){
                            lolito=2;
                        }else if(verdad==a.matches(DEL) && lolito==2){
                            lolito=0;
                        }else{
                            lolito=4;
                        }
                    }

                    int aid2=1,aoa2=1,aas2=1,asep2=1,acne2=1,acnpf2=1,adel2=1,atd2=1,cambiar=1,opre2=1,oplb2=1,whle2=1;

                    for (int j = 0; j < guardar.size(); j++) {
                        if(a.equals(guardar.get(j))){
                            cambiar=0;
                            r=0;
                            break;
                        }else{
                            if(guardar.get(j)!=null){
                                if(verdad==guardar.get(j).matches(TD)){
                                    atd2++;
                                }else if(verdad==guardar.get(j).matches(ID)){
                                    aid2++;
                                }else if(verdad==guardar.get(j).matches(OA)){
                                    aoa2++;
                                }else if(verdad==guardar.get(j).matches(AS)){
                                    aas2++;
                                }else if(verdad==guardar.get(j).matches(CNE)){
                                    acne2++;
                                }else if(verdad==guardar.get(j).matches(CNPF)){
                                    acnpf2++;
                                }else if(verdad==guardar.get(j).matches(DEL)){
                                    adel2++;
                                }else if(verdad==guardar.get(j).matches(IGN)){
                                    if(guardar.get(j).equals("while")){
                                        whle2++;
                                    }else{
                                        opre2++;
                                    }
                                }else if(verdad==guardar.get(j).matches(IGNM)){
                                    oplb2++;
                                }else if(verdad==guardar.get(j).matches(ERLXTD)){
                                    atd2++;
                                }else if(verdad==guardar.get(j).matches(ERLXID)){
                                    aid2++;
                                }else if(verdad==guardar.get(j).matches(ERLXOA)){
                                    aoa2++;
                                }else if(verdad==guardar.get(j).matches(ERLXAS)){
                                    aas2++;
                                }else if(verdad==guardar.get(j).matches(ERLXSEP)){
                                    asep2++;
                                }else if(verdad==guardar.get(j).matches(ERLXCNPF)){
                                    acnpf2++;
                                }else if(verdad==guardar.get(j).matches(ERLXCNE)){
                                    acne2++;
                                }else if(verdad==guardar.get(j).matches(ERLXDEL)){
                                    adel2++;
                                }
                                cambiar=1;

                            }}
                        }

                        if(a.equals("\n") ){
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
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                            }
                            r=0;

                        }else if(verdad==a.matches(ID)){
                            
                                Errorsem f = new Errorsem(guardar3,a);
                                f.vardeclaradas();
                                datos3[1]=f.datos3[1];
                                b=f.b;

                                Errorsem d = new Errorsem(guardar2,guardar4,guardar5,p,a,h,b);
                                d.Nodeclarados();
                                k=d.k;

                                if(b==5 && k==0 && guardar3.size()>2){
                                    /*datos2[1]=a;
                                    datos2[0]="ERRSEM"+errsem;
                                    datos2[2]=String.valueOf(p);
                                    datos2[3]="Variable no definida";
                                    model2.addRow(datos2);
                                    tablavts2.setModel(model2); */
                                    guardar4.add(a+p);
                                    h++;errsem++;
                                }else if(b==0){
                                    Errorsem m = new Errorsem(guardar2,guardar5,a,l,b);
                                    m.Declarados();
                                    u=m.u;

                                    if(u==0){

                                       /* datos3[0]=a;
                                        model3.addRow(datos3);
                                        tablavtss.setModel(model3);
                                        */guardar5.add(a);
                                        /*l++; */
                                    }

                                    Errorsem N = new Errorsem(guardar2,guardar4,guardar7,p,a,v,b);
                                    N.declarados2();
                                    k=N.k;

                                    if(oa==0 && k==0){

                                        if(guardar6.size()>0){
                                            if(!datos3[1].equals(guardar6.get(0))){
                                                if(guardar10.size()>0){
                                                    for (int i = 0; i < guardar10.size(); i++) {

                                                        if(p==Integer.parseInt(guardar10.get(i))){
                                                            unm=1;
                                                            break;
                                                        }else{
                                                            unm=0;
                                                        }
                                                    }
                                                    if(unm==0){
                                                        guardar10.add(String.valueOf(p));
                                                    }
                                                }else{
                                                    guardar10.add(String.valueOf(p));
                                                }

                                                if(unm!=1){
                                                    System.out.println(p);
                                                    datos2[1]=guardar7.get(1);
                                                    datos2[0]="ERRSEM"+errsem;
                                                    datos2[2]=String.valueOf(p);
                                                    datos2[3]="Incompatibilidad de tipos";
                                                    model2.addRow(datos2);
                                                    tablavts2.setModel(model2);
                                                    errsem++;
                                                    guardar4.add(a+p);
                                                    v++;
                                                }
                                            }

                                        }
                                        if(guardar7.size()>0 | guardar6.size()>0){

                                            if(as==0){  //Metodo para saber si una igualacion es correcta tipo int a=string b
                                                if(!datos3[1].equals(guardar7.get(0)) || !guardar6.get(0).equals(guardar7.get(0)) ){
                                                    if(guardar10.size()>0){
                                                        for (int i = 0; i < guardar10.size(); i++) {
                                                            if(p==Integer.parseInt(guardar10.get(i))){
                                                                unm=1;
                                                                break;
                                                            }else{
                                                                unm=0;
                                                            }
                                                        }
                                                        if(unm==0){
                                                            guardar10.add(String.valueOf(p));
                                                        }
                                                    }else{
                                                        guardar10.add(String.valueOf(p));
                                                    }
                                                    System.out.println(guardar10+" 1");
                                                    if(unm!=1){
                                                        datos2[1]=guardar7.get(1);
                                                        datos2[0]="ERRSEM"+errsem;
                                                        datos2[2]=String.valueOf(p);
                                                        datos2[3]="Incompatibilidad de tipos";
                                                        model2.addRow(datos2);
                                                        tablavts2.setModel(model2);
                                                        errsem++;
                                                        as=5;
                                                        guardar4.add(guardar7.get(1)+p);
                                                        v++;
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }

                                if(cambiar==0){
                                    bw.write("VAR"+aid2+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="VAR"+aid;
                                    bw.write("VAR"+aid+" ");
                                    aid++;
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                    datos[2]="";
                                }
                                datos3[1]=""; guardar6.clear(); r=0;  oa=5;
                            
                        }else if(verdad==a.matches(OA)){
                            String j=guardar3.get(guardar3.size()-2);
                            Errorsem o = new Errorsem(guardar3,guardar6,j);
                            o.Aritmetico();
                            oa=o.as;
                            guardar6=o.guardar7;

                            for (int i = 0; i < guardar3.size() ; i++) {

                                if(guardar3.get(i).equals(j)){
                                    if(i>0){
                                        if(verdad==guardar3.get(i-1).matches(TD)){
                                            guardar6.add(guardar3.get(i-1));
                                            oa=0;
                                            break;
                                        }else{
                                            System.out.println(guardar3.get(i));
                                            if(guardar3.get(i-1).equals(",")){
                                                if(verdad==guardar3.get(i-3).matches(TD)){
                                                    oa=0;
                                                    break;
                                                }else{
                                                    oa=5;
                                                }
                                            }else{
                                                    oa=5;
                                                    datos2[1]=guardar7.get(1);
                                                    datos2[0]="ERRSEM"+errsem;
                                                    datos2[2]=String.valueOf(p);
                                                    datos2[3]="Incompatibilidad de tipos";
                                                    model2.addRow(datos2);
                                                    tablavts2.setModel(model2);
                                                    errsem++;
                                                    as=5;
                                                    guardar4.add(guardar7.get(1)+p);
                                                    v++;
                                                    guardar10.add(String.valueOf(p));
                                                }

                                        }
                                    }else{
                                        oa=5;
                                    }

                                }}
                                if(cambiar==0){
                                    bw.write("OA"+aoa2+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="OA"+aoa;
                                    bw.write("OA"+aoa+" ");
                                    aoa++;
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                }
                                r=0;
                            }else if(verdad==a.matches(AS)){
                                String j=guardar3.get(guardar3.size()-2);
                                Errorsem o = new Errorsem(guardar3,guardar7,j);
                                o.Igualacion();
                                as=o.as;
                                guardar7=o.guardar7;

                                if(cambiar==0){
                                    bw.write("OAS"+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="OAS";
                                    bw.write("OAS"+" ");
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                }
                                r=0;
                            }else if(verdad==a.matches(CNE)){

                                if(oa==0){
                                    if(guardar6.size()>0){

                                        if(!"int".equals(guardar6.get(0))){
                                            if(guardar10.size()>0){
                                                for (int i = 0; i < guardar10.size(); i++) {
                                                    if(p==Integer.parseInt(guardar10.get(i))){
                                                        break;
                                                    }
                                                }
                                            }else{
                                                guardar10.add(String.valueOf(p));
                                            }
                                            datos2[1]=a;
                                            datos2[0]="ERRSEM"+errsem;
                                            datos2[2]=String.valueOf(p);
                                            datos2[3]="Incompatibilidad de tipos";
                                            model2.addRow(datos2);
                                            tablavts2.setModel(model2);
                                            errsem++;
                                        }
                                    } if(guardar6.size()>0 && guardar7.size()>0){
                                        System.out.println("vrgadettt");
                                        if(as==0){
                                            if(!"int".equals(guardar7.get(0)) || !guardar6.get(0).equals(guardar7.get(0))){
                                                if(guardar10.size()>0){
                                                    for (int i = 0; i < guardar10.size(); i++) {
                                                        if(p==Integer.parseInt(guardar10.get(i))){
                                                            break;
                                                        }
                                                    }
                                                }else{
                                                    guardar10.add(String.valueOf(p));
                                                }
                                                datos2[1]=guardar7.get(1);
                                                datos2[0]="ERRSEM"+errsem;
                                                datos2[2]=String.valueOf(p);
                                                datos2[3]="Incompatibilidad de tipos";
                                                model2.addRow(datos2);
                                                tablavts2.setModel(model2);
                                                errsem++;
                                                as=5;
                                            }

                                        }
                                    }

                                }
                                guardar6.clear();

                                if(cambiar==0){
                                    bw.write("NE"+acne2+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="NE"+acne;
                                    bw.write("NE"+acne+" ");
                                    acne++;
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                }
                                r=0;
                            }else if(verdad==a.matches(CNPF)){
                                if(cambiar==0){
                                    bw.write("NPD"+acnpf2+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="NPD"+acnpf;
                                    bw.write("NPD"+acnpf+" ");
                                    acnpf++;
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                }
                                r=0;
                            }else if(verdad==a.matches(DEL)){
                                if(lolito==0 && a.equals("(")){

                                    int indiceUltimaFila = model3.getRowCount() - 1;
                                    model3.removeRow(indiceUltimaFila);
                                    lolito=4;
                                }
                                if(cambiar==0){
                                    bw.write("SEP"+adel2+" ");
                                }else{
                                    datos[1]=a;
                                    datos[0]="SEP"+adel;
                                    bw.write("SEP"+adel+" ");
                                    adel++;
                                    guardar.add(datos[1]);
                                    model.addRow(datos);
                                    tablavts.setModel(model);
                                    auxiliando++;
                                }
                                r=0;
                            }else if((verdad==a.matches(IGN)|(verdad==a.matches(IGNM)))){
                                if(a.equals("while") && a.matches(IGN)){
                                    if(cambiar==0){
                                        bw.write("WH"+whle2+" ");
                                    }else{
                                        datos[0]="WH"+whle;
                                        bw.write("WH"+whle+" ");
                                        whle++;
                                        datos[1]=a;
                                        guardar.add(datos[1]);
                                        model.addRow(datos);
                                        tablavts.setModel(model);
                                    }
                                }else if(a.matches(IGNM)){
                                    if(cambiar==0){
                                        bw.write("OL"+oplb2+" ");
                                    }else{
                                        datos[0]="OL"+oplb;
                                        bw.write("OL"+oplb+" ");
                                        datos[1]=a;
                                        guardar.add(datos[1]);
                                        model.addRow(datos);
                                        tablavts.setModel(model);
                                        oplb++;
                                    }
                                }else if(a.matches(IGN)){
                                    if(cambiar==0){
                                        bw.write("OR"+opre2+" ");
                                    }else{
                                        datos[0]="OR" + opre;
                                        bw.write("OR" + opre+" ");
                                        datos[1]=a;
                                        guardar.add(datos[1]);
                                        model.addRow(datos);
                                        tablavts.setModel(model);
                                        opre++;
                                    }
                                }
                                r=0;
                            }else if(verdad==a.matches(ERLXTD) && r==1) {
                                datos[0]="ERLXTIDA"+atd;
                                datos[1]=a;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos2[1]=a;
                                datos2[0]="ERLXTIDA"+atd;
                                bw.write("ERLXTIDA"+atd+" ");
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Incorrecto el tipo \nde dato";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                atd++;
                                B=8;
                                r=0;
                            }else if(verdad==a.matches(ERLXID) && r==1) {
                                datos[0]="ERLXIDEN"+aid;
                                datos[1]=a;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos2[1]=a;
                                datos2[0]="ERLXIDEN"+aid;
                                bw.write("ERLXIDEN"+aid+" ");
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Incorrecto el identificador";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                aid++;
                                r=0;
                            }else if(verdad==a.matches(ERLXOA) && r==1) {
                                datos[0]="ERLXOPAR"+aoa;
                                datos[1]=a;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos2[1]=a;
                                datos2[0]="ERLXOPAR"+aoa;
                                bw.write("ERLXOPAR"+aoa+" ");
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Incorrecto el operador";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                aoa++;
                                r=0;
                            }else if(verdad==a.matches(ERLXAS) && r==1) {
                                datos[0]="ERLXOPAS"+aas;
                                datos[1]=a;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos2[1]=a;
                                datos2[0]="ERLXOPAS";
                                bw.write("ERLXOPAS"+" ");
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Incorrecto la asignacion";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                r=0;
                            }else if(verdad==a.matches(ERLXDEL) && r==1) {
                                datos[0]="ERLXSEPA"+adel;
                                datos[1]=a;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos2[1]=a;
                                datos2[0]="ERLXSEPA"+adel;
                                bw.write("ERLXSEPA"+adel+" ");
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Incorrecto el delimitador";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                adel++;
                                r=0;
                            }else if(r==1) {

                                datos2[1]=a;
                                datos2[0]="ERLXLEX"+lex;
                                bw.write("ERLXLEX" +lex+ " ");
                                lex++;
                                datos2[2]=String.valueOf(p);
                                datos2[3]="Error Lexico";
                                model2.addRow(datos2);
                                tablavts2.setModel(model2);
                                r=0;
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
    javax.swing.JButton btn1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JTabbedPane jTabbedPane1;
    javax.swing.JTable tablavts;
    javax.swing.JTable tablavts2;
    javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
}
