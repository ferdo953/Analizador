package Analizador;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;


public class Proyecto extends javax.swing.JFrame {
    String ruta = "C:/Users/Public/archivo.txt";
    File archivo = new File(ruta);
    BufferedWriter bw;
    String ruta2 = "C:/Users/Public/archivoOpti.txt";
    File archivo4 = new File(ruta2);
    BufferedWriter bwt;
    
    String expresion;
    String Lenguaje="";
    String TD = "(@ABIO7|8num|Hack%)";
    String ID = "[A-Z]([A-Za-z]|_|-|(\\d))*(&)*#";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablavts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablavts2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        btn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablavtss = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

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

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

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

        tablavtss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lexama", "Tipo"
            }
        ));
        jScrollPane4.setViewportView(tablavtss);

        jLabel4.setText("Tabla Ids Declarados");

        jLabel6.setText("Entradas al Programa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
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
            tablavtss.setModel(model3);
            
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
                            }else if(verdad==guardar.get(j).matches(SEP)){   
                                asep2++;
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
                        bw.write("TIDA"+atd2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="TIDA"+atd;
                        bw.write("TIDA"+atd+" ");                         
                        atd++;
                        guardar.add(datos[1]);
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++;
                    }
                    r=0;
                    
                }else if(verdad==a.matches(ID)){
                    if(a.length()>8){
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
                    }else{
                        
                    
                    Errorsem f = new Errorsem(guardar3,a);
                    f.vardeclaradas();
                    datos3[1]=f.datos3[1];
                    b=f.b;
                    
                    Errorsem d = new Errorsem(guardar2,guardar4,guardar5,p,a,h,b);
                    d.Nodeclarados();
                    k=d.k;
                    
                    if(b==5 && k==0 && guardar3.size()>2){
                            datos2[1]=a;
                            datos2[0]="ERRSEM"+errsem;   
                            datos2[2]=String.valueOf(p);
                            datos2[3]="Variable no definida";
                            model2.addRow(datos2);
                            tablavts2.setModel(model2); 
                            guardar4.add(a+p);
                            h++;errsem++;
                    }else if(b==0){
                        Errorsem m = new Errorsem(guardar2,guardar5,a,l,b);
                        m.Declarados();
                        u=m.u;  
                       
                        if(u==0){
                            
                            datos3[0]=a;                               
                            model3.addRow(datos3);
                            tablavtss.setModel(model3);
                            guardar5.add(a);
                            l++;
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
                               bw.write("IDEN"+aid2+" ");
                        }else{
                                datos[1]=a;
                                datos[0]="IDEN"+aid;
                                bw.write("IDEN"+aid+" ");
                                aid++;
                                guardar.add(datos[1]);
                                model.addRow(datos);
                                tablavts.setModel(model);
                                auxiliando++;
                                datos[2]="";
                            }
                    datos3[1]=""; guardar6.clear(); r=0;  oa=5;
                    }
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
                                    if(guardar3.get(i-1).equals(",")){
                                        if(verdad==guardar3.get(i-3).matches(TD)){
                                            System.out.println("hika");                             
                                            oa=0;
                                            break;
                                        }else{
                                            oa=5; 
                                        }
                                    }  

                                }     
                             }else{
                                 oa=5;
                             }
                               
                    }}
                     if(cambiar==0){
                        bw.write("OPAR"+aoa2+" ");
                    }else{                     
                        datos[1]=a;
                        datos[0]="OPAR"+aoa;
                        bw.write("OPAR"+aoa+" ");
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
                        bw.write("OPAS"+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="OPAS";
                        bw.write("OPAS"+" ");
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
                        bw.write("NUEN"+acne2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="NUEN"+acne;
                        bw.write("NUEN"+acne+" ");
                        acne++;
                        guardar.add(datos[1]);
                        model.addRow(datos);
                        tablavts.setModel(model);
                        auxiliando++; 
                     }    
                     r=0;  
                }else if(verdad==a.matches(CNPF)){
                     if(cambiar==0){
                        bw.write("NUPD"+acnpf2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="NUPD"+acnpf;
                        bw.write("NUPD"+acnpf+" ");
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
                        bw.write("SEPA"+adel2+" ");
                    }else{
                        datos[1]=a;
                        datos[0]="SEPA"+adel;
                        bw.write("SEPA"+adel+" ");
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
                            bw.write("WHLE"+whle2+" ");
                        }else{
                            datos[0]="WHLE"+whle;
                            bw.write("WHLE"+whle+" ");
                            whle++;
                            datos[1]=a;
                            guardar.add(datos[1]);
                            model.addRow(datos);
                            tablavts.setModel(model);
                        }
                    }else if(a.matches(IGNM)){
                        System.out.println("contar");
                        if(cambiar==0){
                            bw.write("OPLB"+oplb2+" ");
                        }else{
                            datos[0]="OPLB"+oplb;
                            bw.write("OPLB"+oplb+" ");
                            datos[1]=a;
                            guardar.add(datos[1]);
                            model.addRow(datos);
                            tablavts.setModel(model);
                            oplb++;
                        }
                    }else if(a.matches(IGN)){
                        if(cambiar==0){
                            bw.write("OPRE"+opre2+" ");
                        }else{
                            datos[0]="OPRE" + opre;
                            bw.write("OPRE" + opre+" ");
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
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JTable tablavts;
    javax.swing.JTable tablavts2;
    javax.swing.JTable tablavtss;
    javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
}
