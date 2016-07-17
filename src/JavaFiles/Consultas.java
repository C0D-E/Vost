package JavaFiles;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Consultas extends javax.swing.JFrame {

    /*Representación por medio de clave de los contadores
     public int MPrimerVez[]={MPVm1A,MPV1A,MPV2a4A,MPV5a9A,MPV10a14A,MPV15a19A,MPV20a29A,MPV30a49A,MPV50a59A,MPV60yMas};
     public int HPrimerVez[]={HPVm1A,HPV1A,HPV2a4A,HPV5a9A,HPV10a14A,HPV15a19A,HPV20a29A,HPV30a49A,HPV50a59A,HPV60yMas};
     public int MSubSecuente[]={MSsm1A,MSs1A,MSs2a4A,MSs5a9A,MSs10a14A,MSs15a19A,MSs20a29A,MSs30a49A,MSs50a59A,MSs60yMas};
     public int HSubSecuente[]={HSsm1A,HSs1A,HSs2a4A,HSs5a9A,HSs10a14A,HSs15a19A,HSs20a29A,HSs30a49A,HSs50a59A,HSs60yMas};
     public int MSeguroPopular[]={Mm1ASP,M1ASP,M2a4ASP,M5a9ASP,M10a14ASP,M15a19ASP,M20a29ASP,M30a49ASP,M50a59ASP,M60yMasSP};
     public int HSeguroPopular[]={Hm1ASP,H1ASP,H2a4ASP,H5a9ASP,H10a14ASP,H15a19ASP,H20a29ASP,H30a49ASP,H50a59ASP,H60yMasSP};
     public int MProspera[]={Mm1AP,M1AP,M2a4AP,M5a9AP,M10a14AP,M15a19AP,M20a29AP,M30a49AP,M50a59AP,M60yMasP};
     public int HProspera[]={Hm1AP,H1AP,H2a4AP,H5a9AP,H10a14AP,H15a19AP,H20a29AP,H30a49AP,H50a59AP,H60yMasP};
     public int MPorAño[]={PVAm1A,PVA1A,PVA2a4A,PVA5a9A,PVA10a14A,PVA15a19A,PVA20a29A,PVA30a49A,PVA50a59A,PVA60yMas};
     public int HPorAño[]={PVAm1A,PVA1A,PVA2a4A,PVA5a9A,PVA10a14A,PVA15a19A,PVA20a29A,PVA30a49A,PVA50a59A,PVA60yMas};*/

    public int MPrimerVez[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int HPrimerVez[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int MSubSecuente[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int HSubSecuente[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int MSeguroPopular[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int HSeguroPopular[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int PReferidos[] = {0, 0};
    public int PDerHab[] = {0, 0, 0, 0};
    public int PPPrimerVez[] = {0, 0, 0, 0, 0, 0, 0};
    public int PPSubSecuente[] = {0, 0, 0, 0, 0, 0, 0};
    public int SPPrograma[] = {0, 0, 0, 0, 0, 0, 0};
    public int MPorAño[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int HPorAño[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static String Edades[] = {"< 1 Año", "1 Año", "2-4 Años", "5-9 Años", "10-14 Años", "15-19 Años", "20-29 Años", "30-49 Años", "50-59 Años", "60 y Mas Años"};
    public static String Variables[] = {"Enfermedades Transmisibles", "Crónico Degenerativas", "Otras Enfermedades", "A Sanos", "Planificación Familiar", "Salud Bucal", "Salud Mental"};

    public static int Mujeres, Hombres, Primerizas, Primerizos, MSubsecuentes, HSubsecuentes, MPConSeguroPopular, MSSConSeguroPopular, MConSeguroPopular, HPConSeguroPopular, HSSConSeguroPopular, HConSeguroPopular, ConProspera;
    public static int PPPrimerVezCount, PPSubSecuenteCount, PPSP;
    public static String Sexo, Frec, Edad, Referencia, Program, SeguroP, DerechoHabiencia, PorProg, NoMedicas, Cobertura, Clave;
    public static Sujeto Persona, Personas[] = new Sujeto[500];
    public static Recorder Rec;
    public static Editor editorWin;
    public static TablaDeTotales tablaTotales;
    public static int ControlRB, ControlP = 0, ControlSexo, ControlFreq, ControlProg, ControlAux, ControlGuardado = 0, ControlEdit = 0;

    public Consultas() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        initComponents();
        setCursor(null); 
        /*
        Color PanelC=new Color(135, 207, 235);
        Color Panelitos=new Color(165, 219, 240);
        this.getContentPane().setBackground(Panelitos);
        Consulta.setBackground(Panelitos);
        PanReferencia.setBackground(Panelitos);
        PanSeguroPopular.setBackground(Panelitos);
        PanDerechoHabiencia.setBackground(Panelitos);
        PanVariable.setBackground(Panelitos);
        PanPrograma.setBackground(Panelitos);
        PanEdad.setBackground(Panelitos);
        PanFrecuencia.setBackground(Panelitos);
        PanSexo.setBackground(Panelitos);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GCSexo = new javax.swing.ButtonGroup();
        GCFrecuencia = new javax.swing.ButtonGroup();
        GCEdad = new javax.swing.ButtonGroup();
        GPPVariable = new javax.swing.ButtonGroup();
        GReferencia = new javax.swing.ButtonGroup();
        GProspera = new javax.swing.ButtonGroup();
        GSeguroPopular = new javax.swing.ButtonGroup();
        GDerechoHabiencia = new javax.swing.ButtonGroup();
        SelectorDeArchivos = new javax.swing.JFileChooser();
        GPorAño = new javax.swing.ButtonGroup();
        Consulta = new javax.swing.JPanel();
        PanSexo = new javax.swing.JPanel();
        SMujer = new javax.swing.JRadioButton();
        SHombre = new javax.swing.JRadioButton();
        PanEdad = new javax.swing.JPanel();
        Em1Año = new javax.swing.JRadioButton();
        E1Año = new javax.swing.JRadioButton();
        E2a4Años = new javax.swing.JRadioButton();
        E5a9Años = new javax.swing.JRadioButton();
        E10a14Años = new javax.swing.JRadioButton();
        E15a19Años = new javax.swing.JRadioButton();
        E20a29Años = new javax.swing.JRadioButton();
        E30a49Años = new javax.swing.JRadioButton();
        E50a59Años = new javax.swing.JRadioButton();
        E60YMasAños = new javax.swing.JRadioButton();
        PanFrecuencia = new javax.swing.JPanel();
        FPrimeraVez = new javax.swing.JRadioButton();
        FSubsecuente = new javax.swing.JRadioButton();
        PanCobertura = new javax.swing.JPanel();
        PrimeraVezEnElAno = new javax.swing.JRadioButton();
        NAPrimeraVezEnElAno = new javax.swing.JRadioButton();
        PanReferencia = new javax.swing.JPanel();
        PacientesReferidos = new javax.swing.JRadioButton();
        PacientesContraReferidos = new javax.swing.JRadioButton();
        NAReferencia = new javax.swing.JRadioButton();
        PanPrograma = new javax.swing.JPanel();
        Prospera = new javax.swing.JRadioButton();
        NAProspera = new javax.swing.JRadioButton();
        PanDerechoHabiencia = new javax.swing.JPanel();
        DHIMSS = new javax.swing.JRadioButton();
        DHISSSTE = new javax.swing.JRadioButton();
        DHSMNG = new javax.swing.JRadioButton();
        DHOtras = new javax.swing.JRadioButton();
        NADH = new javax.swing.JRadioButton();
        PanVariable = new javax.swing.JPanel();
        VEnfermedadesTransmisibles = new javax.swing.JRadioButton();
        VCronicoDegenerativas = new javax.swing.JRadioButton();
        VOtrasEnfermedades = new javax.swing.JRadioButton();
        VASanos = new javax.swing.JRadioButton();
        VPlanificacionFamiliar = new javax.swing.JRadioButton();
        VSaludBucal = new javax.swing.JRadioButton();
        VSaludMental = new javax.swing.JRadioButton();
        NAVariable = new javax.swing.JRadioButton();
        Añadir = new javax.swing.JButton();
        Mostrar = new javax.swing.JButton();
        MTotales = new javax.swing.JButton();
        PanSeguroPopular = new javax.swing.JPanel();
        SeguroPopular = new javax.swing.JRadioButton();
        NASeguroPopular = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        MenuBar = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        GuardarBDD = new javax.swing.JMenuItem();
        GuardarAPDF = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        AbrirBDD = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        AyudaItem = new javax.swing.JMenuItem();
        AcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Informe Mensual de Actividades Realizadas en la Unidad Médica - IMARúM");
        setBackground(new java.awt.Color(204, 204, 255));
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Consulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        PanSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GCSexo.add(SMujer);
        SMujer.setText("Mujer");

        GCSexo.add(SHombre);
        SHombre.setText("Hombre");

        javax.swing.GroupLayout PanSexoLayout = new javax.swing.GroupLayout(PanSexo);
        PanSexo.setLayout(PanSexoLayout);
        PanSexoLayout.setHorizontalGroup(
            PanSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SMujer)
                    .addComponent(SHombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanSexoLayout.setVerticalGroup(
            PanSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSexoLayout.createSequentialGroup()
                .addComponent(SMujer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SHombre))
        );

        PanEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GCEdad.add(Em1Año);
        Em1Año.setText("< 1 Año");

        GCEdad.add(E1Año);
        E1Año.setText("1 Año");

        GCEdad.add(E2a4Años);
        E2a4Años.setText("2-4 Años");

        GCEdad.add(E5a9Años);
        E5a9Años.setText("5-9 Años");

        GCEdad.add(E10a14Años);
        E10a14Años.setText("10-14 Años");

        GCEdad.add(E15a19Años);
        E15a19Años.setText("15-19 Años");

        GCEdad.add(E20a29Años);
        E20a29Años.setText("20-29 Años");

        GCEdad.add(E30a49Años);
        E30a49Años.setText("30-49 Años");

        GCEdad.add(E50a59Años);
        E50a59Años.setText("50-59 Años");

        GCEdad.add(E60YMasAños);
        E60YMasAños.setText("60 y Más Años");

        javax.swing.GroupLayout PanEdadLayout = new javax.swing.GroupLayout(PanEdad);
        PanEdad.setLayout(PanEdadLayout);
        PanEdadLayout.setHorizontalGroup(
            PanEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanEdadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Em1Año)
                    .addComponent(E1Año)
                    .addComponent(E2a4Años)
                    .addComponent(E5a9Años)
                    .addComponent(E10a14Años))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(E15a19Años)
                    .addComponent(E20a29Años)
                    .addComponent(E30a49Años)
                    .addComponent(E50a59Años)
                    .addComponent(E60YMasAños)))
        );
        PanEdadLayout.setVerticalGroup(
            PanEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanEdadLayout.createSequentialGroup()
                .addGroup(PanEdadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanEdadLayout.createSequentialGroup()
                        .addComponent(E15a19Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E20a29Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E30a49Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E50a59Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E60YMasAños))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanEdadLayout.createSequentialGroup()
                        .addComponent(Em1Año)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E1Año)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E2a4Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E5a9Años)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E10a14Años)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanFrecuencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Frecuencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GCFrecuencia.add(FPrimeraVez);
        FPrimeraVez.setText("Primera vez");

        GCFrecuencia.add(FSubsecuente);
        FSubsecuente.setText("Subsecuente");

        javax.swing.GroupLayout PanFrecuenciaLayout = new javax.swing.GroupLayout(PanFrecuencia);
        PanFrecuencia.setLayout(PanFrecuenciaLayout);
        PanFrecuenciaLayout.setHorizontalGroup(
            PanFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanFrecuenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FPrimeraVez)
                    .addComponent(FSubsecuente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanFrecuenciaLayout.setVerticalGroup(
            PanFrecuenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanFrecuenciaLayout.createSequentialGroup()
                .addComponent(FPrimeraVez, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FSubsecuente))
        );

        PanCobertura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cobertura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GPorAño.add(PrimeraVezEnElAno);
        PrimeraVezEnElAno.setText("Primera vez en el año");

        GPorAño.add(NAPrimeraVezEnElAno);
        NAPrimeraVezEnElAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NAPrimeraVezEnElAno.setText("No Aplica");

        javax.swing.GroupLayout PanCoberturaLayout = new javax.swing.GroupLayout(PanCobertura);
        PanCobertura.setLayout(PanCoberturaLayout);
        PanCoberturaLayout.setHorizontalGroup(
            PanCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanCoberturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrimeraVezEnElAno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAPrimeraVezEnElAno)
                .addGap(30, 30, 30))
        );
        PanCoberturaLayout.setVerticalGroup(
            PanCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanCoberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(PrimeraVezEnElAno)
                .addComponent(NAPrimeraVezEnElAno))
        );

        javax.swing.GroupLayout ConsultaLayout = new javax.swing.GroupLayout(Consulta);
        Consulta.setLayout(ConsultaLayout);
        ConsultaLayout.setHorizontalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanCobertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanFrecuencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ConsultaLayout.setVerticalGroup(
            ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ConsultaLayout.createSequentialGroup()
                        .addComponent(PanSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanReferencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Referencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GReferencia.add(PacientesReferidos);
        PacientesReferidos.setText("Pacientes Referidos");

        GReferencia.add(PacientesContraReferidos);
        PacientesContraReferidos.setText("Pacientes Contrarreferidos");

        GReferencia.add(NAReferencia);
        NAReferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NAReferencia.setText("No Aplica");
        NAReferencia.setToolTipText("");

        javax.swing.GroupLayout PanReferenciaLayout = new javax.swing.GroupLayout(PanReferencia);
        PanReferencia.setLayout(PanReferenciaLayout);
        PanReferenciaLayout.setHorizontalGroup(
            PanReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanReferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PacientesReferidos)
                    .addComponent(PacientesContraReferidos)
                    .addComponent(NAReferencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanReferenciaLayout.setVerticalGroup(
            PanReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanReferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PacientesReferidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PacientesContraReferidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAReferencia))
        );

        PanPrograma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prospera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GProspera.add(Prospera);
        Prospera.setText("Prospera");

        GProspera.add(NAProspera);
        NAProspera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NAProspera.setText("No Aplica");
        NAProspera.setToolTipText("");

        javax.swing.GroupLayout PanProgramaLayout = new javax.swing.GroupLayout(PanPrograma);
        PanPrograma.setLayout(PanProgramaLayout);
        PanProgramaLayout.setHorizontalGroup(
            PanProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NAProspera)
                    .addComponent(Prospera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanProgramaLayout.setVerticalGroup(
            PanProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanProgramaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Prospera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NAProspera))
        );

        PanDerechoHabiencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Derechohabiencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GDerechoHabiencia.add(DHIMSS);
        DHIMSS.setText("IMSS");

        GDerechoHabiencia.add(DHISSSTE);
        DHISSSTE.setText("ISSSTE");

        GDerechoHabiencia.add(DHSMNG);
        DHSMNG.setText("SMNG");

        GDerechoHabiencia.add(DHOtras);
        DHOtras.setText("Otras");

        GDerechoHabiencia.add(NADH);
        NADH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NADH.setText("No Aplica");
        NADH.setToolTipText("");

        javax.swing.GroupLayout PanDerechoHabienciaLayout = new javax.swing.GroupLayout(PanDerechoHabiencia);
        PanDerechoHabiencia.setLayout(PanDerechoHabienciaLayout);
        PanDerechoHabienciaLayout.setHorizontalGroup(
            PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanDerechoHabienciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DHSMNG)
                    .addGroup(PanDerechoHabienciaLayout.createSequentialGroup()
                        .addGroup(PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DHIMSS)
                            .addComponent(DHISSSTE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NADH)
                            .addComponent(DHOtras))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanDerechoHabienciaLayout.setVerticalGroup(
            PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanDerechoHabienciaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DHIMSS)
                    .addComponent(DHOtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanDerechoHabienciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DHISSSTE)
                    .addComponent(NADH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DHSMNG))
        );

        PanVariable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Por Programa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GPPVariable.add(VEnfermedadesTransmisibles);
        VEnfermedadesTransmisibles.setText("Enfermedades Transmisibles");

        GPPVariable.add(VCronicoDegenerativas);
        VCronicoDegenerativas.setText("Crónico Degenerativas");

        GPPVariable.add(VOtrasEnfermedades);
        VOtrasEnfermedades.setText("Otras Enfermedades");

        GPPVariable.add(VASanos);
        VASanos.setText("A Sanos");

        GPPVariable.add(VPlanificacionFamiliar);
        VPlanificacionFamiliar.setText("Planificación Familiar");

        GPPVariable.add(VSaludBucal);
        VSaludBucal.setText("Salud Bucal");

        GPPVariable.add(VSaludMental);
        VSaludMental.setText("Salud Mental");

        GPPVariable.add(NAVariable);
        NAVariable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NAVariable.setText("No Aplica");
        NAVariable.setToolTipText("");

        javax.swing.GroupLayout PanVariableLayout = new javax.swing.GroupLayout(PanVariable);
        PanVariable.setLayout(PanVariableLayout);
        PanVariableLayout.setHorizontalGroup(
            PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanVariableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VEnfermedadesTransmisibles)
                    .addComponent(VCronicoDegenerativas)
                    .addComponent(VOtrasEnfermedades)
                    .addComponent(VASanos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VPlanificacionFamiliar)
                    .addComponent(VSaludBucal)
                    .addComponent(VSaludMental)
                    .addComponent(NAVariable)))
        );
        PanVariableLayout.setVerticalGroup(
            PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanVariableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VPlanificacionFamiliar)
                    .addComponent(VEnfermedadesTransmisibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VSaludBucal)
                    .addComponent(VCronicoDegenerativas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VSaludMental)
                    .addComponent(VOtrasEnfermedades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAVariable)
                    .addComponent(VASanos)))
        );

        Añadir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Añadir.setText("Añadir");
        Añadir.setToolTipText("Añade los datos de la persona a la base de datos");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });

        Mostrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mostrar.setText("Mostrar");
        Mostrar.setToolTipText("Despliega los datos tal como fueron ingresados en una tabla");
        Mostrar.setPreferredSize(new java.awt.Dimension(57, 17));
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        MTotales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MTotales.setText("Totales");
        MTotales.setToolTipText("Despliega los totales de los datos ingresados en una tabla");
        MTotales.setPreferredSize(new java.awt.Dimension(57, 17));
        MTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTotalesActionPerformed(evt);
            }
        });

        PanSeguroPopular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seguro Popular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        GSeguroPopular.add(SeguroPopular);
        SeguroPopular.setText("Seguro Popular");

        GSeguroPopular.add(NASeguroPopular);
        NASeguroPopular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NASeguroPopular.setText("No Aplica");
        NASeguroPopular.setToolTipText("");

        javax.swing.GroupLayout PanSeguroPopularLayout = new javax.swing.GroupLayout(PanSeguroPopular);
        PanSeguroPopular.setLayout(PanSeguroPopularLayout);
        PanSeguroPopularLayout.setHorizontalGroup(
            PanSeguroPopularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSeguroPopularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanSeguroPopularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeguroPopular)
                    .addComponent(NASeguroPopular))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        PanSeguroPopularLayout.setVerticalGroup(
            PanSeguroPopularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSeguroPopularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeguroPopular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NASeguroPopular))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Infección de transmisión sexual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jRadioButton1.setText("Infectado");

        jRadioButton2.setText("No infectado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Archivo.setText("Archivo");

        GuardarBDD.setText("Guardar BDD");
        GuardarBDD.setToolTipText("Guardar Base De Datos");
        GuardarBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBDDActionPerformed(evt);
            }
        });
        Archivo.add(GuardarBDD);

        GuardarAPDF.setText("Guardar PDF");
        GuardarAPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarAPDFActionPerformed(evt);
            }
        });
        Archivo.add(GuardarAPDF);
        Archivo.add(jSeparator2);

        AbrirBDD.setText("Abrir BDD");
        AbrirBDD.setToolTipText("Abrir Base de Datos");
        AbrirBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirBDDActionPerformed(evt);
            }
        });
        Archivo.add(AbrirBDD);
        Archivo.add(jSeparator1);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        MenuBar.add(Archivo);

        Ayuda.setText("Ayuda");

        AyudaItem.setText("Ayuda");
        AyudaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaItemActionPerformed(evt);
            }
        });
        Ayuda.add(AyudaItem);

        AcercaDe.setText("Acerca de");
        AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaDeActionPerformed(evt);
            }
        });
        Ayuda.add(AcercaDe);

        MenuBar.add(Ayuda);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanVariable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanDerechoHabiencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanSeguroPopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PanReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanDerechoHabiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PanPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanSeguroPopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Añadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Mostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MTotales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        Persona = null;
        Sexo = null;
        Frec = null;
        Edad = null;
        Referencia = null;
        Program = null;
        SeguroP = null;
        DerechoHabiencia = null;
        PorProg = null;
        NoMedicas = null;
        Cobertura = null;
        Clave = null;

        LimpiarControles();

        if (SMujer.isSelected()) {
            Sexo = "Mujer";
            Clave = "M";
        } else if (SHombre.isSelected()) {
            Sexo = "Hombre";
            Clave = "H";
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el \"Sexo\" de la persona");
            ControlRB = 1;

        }
        if (ControlRB == 0) {
            if (FPrimeraVez.isSelected()) {
                Frec = "Primera vez";
                Clave = Clave + "PV";
            } else if (FSubsecuente.isSelected()) {
                Frec = "Subsecuente";
                Clave = Clave + "Ss";
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione la \"Frecuencia\" de asistencia\na la Unidad Médica");
                ControlRB = 1;
            }
            if (ControlRB == 0) {
                if (Em1Año.isSelected()) {
                    Edad = "< 1 Año";
                    Clave = Clave + "m1A";
                } else if (E1Año.isSelected()) {
                    Edad = "1 Año";
                    Clave = Clave + "1A";
                } else if (E2a4Años.isSelected()) {
                    Edad = "2-4 Años";
                    Clave = Clave + "2a4A";
                } else if (E5a9Años.isSelected()) {
                    Edad = "5-9 Años";
                    Clave = Clave + "5a9A";
                } else if (E10a14Años.isSelected()) {
                    Edad = "10-14 Años";
                    Clave = Clave + "10a14A";
                } else if (E15a19Años.isSelected()) {
                    Edad = "15-19 Años";
                    Clave = Clave + "15a19A";
                } else if (E20a29Años.isSelected()) {
                    Edad = "20-29 Años";
                    Clave = Clave + "20a29A";
                } else if (E30a49Años.isSelected()) {
                    Edad = "30-49 Años";
                    Clave = Clave + "30a49";
                } else if (E50a59Años.isSelected()) {
                    Edad = "50-59 Años";
                    Clave = Clave + "50a59";
                } else if (E60YMasAños.isSelected()) {
                    Edad = "60 y más Años";
                    Clave = Clave + "60yMas";
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione el rango de Edad en el\nque se encuentre la persona");
                    ControlRB = 1;
                }
                if (ControlRB == 0) {
                    if (PrimeraVezEnElAno.isSelected()) {
                        Cobertura = "Primera vez en el año";
                    } else if (NAPrimeraVezEnElAno.isSelected()) {
                        Cobertura = "N/A";
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione una opcion de \"Cobertura\"");
                        ControlRB = 1;
                    }
                    if (ControlRB == 0) {
                        if (PacientesReferidos.isSelected()) {
                            Referencia = "Referido";
                        } else if (PacientesContraReferidos.isSelected()) {
                            Referencia = "Contrarreferido";
                        } else if (NAReferencia.isSelected()) {
                            Referencia = "N/A";
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione una opcion de \"Referencia\"");
                                ControlRB = 1;
                        }
                            if (ControlRB == 0) {
                                if (DHIMSS.isSelected()) {
                                    DerechoHabiencia = "IMSS";
                                } else if (DHISSSTE.isSelected()) {
                                    DerechoHabiencia = "ISSSTE";
                                } else if (DHSMNG.isSelected()) {
                                    DerechoHabiencia = "SMNG";
                                } else if (DHOtras.isSelected()) {
                                    DerechoHabiencia = "Otras";
                                } else if (NADH.isSelected()) {
                                    DerechoHabiencia = "N/A";
                                } else {
                                    JOptionPane.showMessageDialog(null, "Seleccione la \"Derechohabiencia\" o \"No Aplica\" en otro caso");
                                    ControlRB = 1;
                                }
                                if (ControlRB == 0) {
                                    if (SeguroPopular.isSelected()) {
                                        SeguroP = "Seguro Popular";
                                    } else if (NASeguroPopular.isSelected()) {
                                        SeguroP = "N/A";
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Seleccione \"Seguro Popular\" o \"No Aplica\" en otro caso");
                                        ControlRB = 1;
                                    }
                                    if (ControlRB == 0) {
                                        if (Prospera.isSelected()) {
                                            Program = "Prospera";
                                        } else if (NAProspera.isSelected()) {
                                            Program = "N/A";
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Seleccione \"Prospera\" o \"No Aplica\" en otro caso");
                                            ControlRB = 1;
                                        }
                                        if (ControlRB == 0) {
                                            if (VEnfermedadesTransmisibles.isSelected()) {
                                                PorProg = "Enfermedades Transmisibles";
                                            } else if (VCronicoDegenerativas.isSelected()) {
                                                PorProg = "Cronico Degenerativas";
                                            } else if (VOtrasEnfermedades.isSelected()) {
                                                PorProg = "Otras Enfermedades";
                                            } else if (VASanos.isSelected()) {
                                                PorProg = "A Sanos";
                                            } else if (VPlanificacionFamiliar.isSelected()) {
                                                PorProg = "Planificacion Familiar";
                                            } else if (VSaludBucal.isSelected()) {
                                                PorProg = "Salud Bucal";
                                            } else if (VSaludMental.isSelected()) {
                                                PorProg = "Salud Mental";
                                            } else if (NAVariable.isSelected()) {
                                                PorProg = "N/A";
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Seleccione una opción de \"Por Programa\" o \"No Aplica\" en otro caso");
                                                ControlRB = 1;
                                            }
                                            if (ControlRB == 0) {
                                                Persona = new Sujeto(Sexo, Frec, Edad, Referencia, Program, SeguroP, DerechoHabiencia, PorProg, Cobertura, Clave);
                                                Personas[ControlP] = Persona;
                                                LimpiarSeleccion();
                                                ControlP++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                }
            }
        }
    }//GEN-LAST:event_AñadirActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tablaTotales = new TablaDeTotales(null, true);
        tablaTotales.setLocationRelativeTo(null);
        tablaTotales.setVisible(false);
        Rec = new Recorder(null, true);
        Rec.setLocationRelativeTo(null);
        Rec.setVisible(false);
        InitVars();
        ControlP = 0;
    }//GEN-LAST:event_formWindowOpened

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
        if (ControlP != 0) {
            LimpiarTabla(Recorder.TablaGnral);
            GenTablaDePersonas();
            Rec.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La Base de Datos está vacía,\nNo hay nada para mostrar");
        }
    }//GEN-LAST:event_MostrarActionPerformed

    private void AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaDeActionPerformed
        Acerca About = new Acerca(null, true);
        About.setLocationRelativeTo(null);
        About.setVisible(true);
    }//GEN-LAST:event_AcercaDeActionPerformed

    private void MTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTotalesActionPerformed
        if (ControlP != 0) {
            InitVars();
            LimpiarTabla(TablaDeTotales.tablaTotal);
            GenTablaDeTotales();
            tablaTotales.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La Base de Datos está vacía,\nNo hay nada para mostrar");
        }
    }//GEN-LAST:event_MTotalesActionPerformed

    private void GuardarAPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarAPDFActionPerformed
        /*   File ruta=new File("%homedrive%");
         SelectorDeArchivos.setCurrentDirectory(ruta);*/
        if (ControlP != 0) {
            DefaultTableModel TGnral = (DefaultTableModel) Recorder.TablaGnral.getModel();
            DefaultTableModel Ttotales = (DefaultTableModel) TablaDeTotales.tablaTotal.getModel();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.pdf", "pdf");
            SelectorDeArchivos.setFileFilter(filtro);
            int op = SelectorDeArchivos.showSaveDialog(this);
            if (op == 0) {
                Document document = new Document(PageSize.LETTER.rotate());
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(SelectorDeArchivos.getSelectedFile() + ".pdf"));
                    document.open();
                    LimpiarTabla(Recorder.TablaGnral);
                    GenTablaDePersonas();
                    PdfPTable TablaPersonas = new PdfPTable(TGnral.getColumnCount());
                    for (int i = 0; i < TGnral.getRowCount(); i++) {
                        for (int j = 0; j < TGnral.getColumnCount(); j++) {
                            if (TGnral.getValueAt(i, j) == null) {
                                TablaPersonas.addCell("");
                            } else {
                                TablaPersonas.addCell(String.valueOf(TGnral.getValueAt(i, j)));
                            }
                        }
                    }
                    InitVars();
                    LimpiarTabla(TablaDeTotales.tablaTotal);
                    GenTablaDeTotales();
                    PdfPTable TablaTotales = new PdfPTable(Ttotales.getColumnCount());
                    for (int i = 0; i < Ttotales.getRowCount(); i++) {
                        for (int j = 0; j < Ttotales.getColumnCount(); j++) {
                            if (Ttotales.getValueAt(i, j) == null) {
                                TablaTotales.addCell("");
                            } else {
                                TablaTotales.addCell(String.valueOf(Ttotales.getValueAt(i, j)));
                            }
                        }
                    }
                    document.add(TablaPersonas);
                    document.newPage();
                    document.add(TablaTotales);
                    /*for (int i = 0; i < TGnral.getDataVector().capacity(); i++) {
                     document.add(new Paragraph(String.valueOf(TGnral.getDataVector().get(i))));
                     }*/
                } catch (FileNotFoundException | DocumentException e) {
                    JOptionPane.showMessageDialog(null, "ERROR - El archivo PDF no se ha podido guardar");
                }
                document.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Base de Datos está vacía,\nNo hay nada que guardar");
        }
    }//GEN-LAST:event_GuardarAPDFActionPerformed
    private void GuardarBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBDDActionPerformed
        if (ControlP != 0) {
            File ruta = new File("%homedrive%");
            SelectorDeArchivos.setCurrentDirectory(ruta);
            int op = SelectorDeArchivos.showSaveDialog(this);
            if (op == 0) {
                File ArchivoBin = SelectorDeArchivos.getSelectedFile();
                try {
                    FileOutputStream FOStream = new FileOutputStream(ArchivoBin + ".bin");
                    ObjectOutputStream ObjetoOut = new ObjectOutputStream(FOStream);
                    ObjetoOut.writeObject(ControlP);
                    for (int i = 0; i < ControlP; i++) {
                        ObjetoOut.writeObject(Personas[i]);
                    }
                    ObjetoOut.flush();
                    ObjetoOut.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido guardar");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido guardar");
                }
                JOptionPane.showMessageDialog(null, "El archivo se guardó exitosamente");
                ControlGuardado = 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La Base de Datos está vacía,\nNo hay nada que guardar");
        }
    }//GEN-LAST:event_GuardarBDDActionPerformed

    private void AbrirBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirBDDActionPerformed
        File ruta = new File("%homedrive%");
        SelectorDeArchivos.setCurrentDirectory(ruta);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.dat,*.bin", "dat", "bin");
        SelectorDeArchivos.setFileFilter(filtro);
        int op = SelectorDeArchivos.showOpenDialog(this);
        if (op == 0) {
            File ArchivoBin = SelectorDeArchivos.getSelectedFile();
            try {
                FileInputStream FIStream = new FileInputStream(ArchivoBin);
                ObjectInputStream ObjetoIn = new ObjectInputStream(FIStream);
                int i = 0;
                ControlP = (int) ObjetoIn.readObject();
                while (i < ControlP) {
                    Personas[i] = (Sujeto) ObjetoIn.readObject();
                    i++;
                }
                ObjetoIn.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido abrir");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido abrir");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERROR - La \"Clase Sujeto\" no se encontró");
            }
            JOptionPane.showMessageDialog(null, "El archivo se abrió exitosamente");
        }
    }//GEN-LAST:event_AbrirBDDActionPerformed

    private void AyudaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaItemActionPerformed
        JOptionPane.showMessageDialog(null, "Lo siento, este apartado aún no está disponible,\n el software sigue en construcción :)");
    }//GEN-LAST:event_AyudaItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(ControlGuardado == 0 && ControlP != 0 && ControlEdit == 1){
            int option = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?");
            if(option == 0){
                File ruta = new File("%homedrive%");
                SelectorDeArchivos.setCurrentDirectory(ruta);
                int op = SelectorDeArchivos.showSaveDialog(this);
                if (op == 0) {
                    File ArchivoBin = SelectorDeArchivos.getSelectedFile();
                    try {
                        FileOutputStream FOStream = new FileOutputStream(ArchivoBin + ".bin");
                        ObjectOutputStream ObjetoOut = new ObjectOutputStream(FOStream);
                        ObjetoOut.writeObject(ControlP);
                        for (int i = 0; i < ControlP; i++) {
                            ObjetoOut.writeObject(Personas[i]);
                        }
                        ObjetoOut.flush();
                        ObjetoOut.close();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido guardar");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "ERROR - El archivo binario no se ha podido guardar");
                    }
                    JOptionPane.showMessageDialog(null, "El archivo se guardó exitosamente");
                }
            }else if(option == 1){
                System.exit(0);
            }
        }else {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/IMARuMLogotipo.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirBDD;
    private javax.swing.JMenuItem AcercaDe;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenuItem AyudaItem;
    private javax.swing.JButton Añadir;
    private javax.swing.JPanel Consulta;
    private javax.swing.JRadioButton DHIMSS;
    private javax.swing.JRadioButton DHISSSTE;
    private javax.swing.JRadioButton DHOtras;
    private javax.swing.JRadioButton DHSMNG;
    private javax.swing.JRadioButton E10a14Años;
    private javax.swing.JRadioButton E15a19Años;
    private javax.swing.JRadioButton E1Año;
    private javax.swing.JRadioButton E20a29Años;
    private javax.swing.JRadioButton E2a4Años;
    private javax.swing.JRadioButton E30a49Años;
    private javax.swing.JRadioButton E50a59Años;
    private javax.swing.JRadioButton E5a9Años;
    private javax.swing.JRadioButton E60YMasAños;
    private javax.swing.JRadioButton Em1Año;
    private javax.swing.JRadioButton FPrimeraVez;
    private javax.swing.JRadioButton FSubsecuente;
    private javax.swing.ButtonGroup GCEdad;
    private javax.swing.ButtonGroup GCFrecuencia;
    private javax.swing.ButtonGroup GCSexo;
    private javax.swing.ButtonGroup GDerechoHabiencia;
    private javax.swing.ButtonGroup GPPVariable;
    private javax.swing.ButtonGroup GPorAño;
    private javax.swing.ButtonGroup GProspera;
    private javax.swing.ButtonGroup GReferencia;
    private javax.swing.ButtonGroup GSeguroPopular;
    private javax.swing.JMenuItem GuardarAPDF;
    private javax.swing.JMenuItem GuardarBDD;
    private javax.swing.JButton MTotales;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JRadioButton NADH;
    private javax.swing.JRadioButton NAPrimeraVezEnElAno;
    private javax.swing.JRadioButton NAProspera;
    private javax.swing.JRadioButton NAReferencia;
    private javax.swing.JRadioButton NASeguroPopular;
    private javax.swing.JRadioButton NAVariable;
    private javax.swing.JRadioButton PacientesContraReferidos;
    private javax.swing.JRadioButton PacientesReferidos;
    private javax.swing.JPanel PanCobertura;
    private javax.swing.JPanel PanDerechoHabiencia;
    private javax.swing.JPanel PanEdad;
    private javax.swing.JPanel PanFrecuencia;
    private javax.swing.JPanel PanPrograma;
    private javax.swing.JPanel PanReferencia;
    private javax.swing.JPanel PanSeguroPopular;
    private javax.swing.JPanel PanSexo;
    private javax.swing.JPanel PanVariable;
    private javax.swing.JRadioButton PrimeraVezEnElAno;
    private javax.swing.JRadioButton Prospera;
    private javax.swing.JRadioButton SHombre;
    private javax.swing.JRadioButton SMujer;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JRadioButton SeguroPopular;
    private javax.swing.JFileChooser SelectorDeArchivos;
    private javax.swing.JRadioButton VASanos;
    private javax.swing.JRadioButton VCronicoDegenerativas;
    private javax.swing.JRadioButton VEnfermedadesTransmisibles;
    private javax.swing.JRadioButton VOtrasEnfermedades;
    private javax.swing.JRadioButton VPlanificacionFamiliar;
    private javax.swing.JRadioButton VSaludBucal;
    private javax.swing.JRadioButton VSaludMental;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables

    public static void LimpiarTabla(JTable tabla) {
        DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();  
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(tableModel.getRowCount() - 1);
        }
    }

    public void LimpiarControles() {
        ControlRB = 0;
        ControlSexo = 0;
        ControlFreq = 0;
        ControlProg = 0;
    }

    public void LimpiarSeleccion() {
        GCSexo.clearSelection();
        GCEdad.clearSelection();
        GCFrecuencia.clearSelection();
        GDerechoHabiencia.clearSelection();
        GPPVariable.clearSelection();
        GProspera.clearSelection();
        GReferencia.clearSelection();
        GSeguroPopular.clearSelection();
        GPorAño.clearSelection();
    }

    public void InitVars() {
        for (int i = 0; i < 10; i++) {
            MPrimerVez[i] = 0;
            HPrimerVez[i] = 0;
            MSubSecuente[i] = 0;
            HSubSecuente[i] = 0;
            MSeguroPopular[i] = 0;
            HSeguroPopular[i] = 0;
        }
        for (int i = 0; i < 7; i++) {
            PPPrimerVez[i] = 0;
            PPSubSecuente[i] = 0;
            SPPrograma[i] = 0;
        }
        for (int i = 0; i < 2; i++) {
            PReferidos[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            PDerHab[i] = 0;
        }
        for (int i = 0; i < 10; i++) {
            MPorAño[i] = 0;
            HPorAño[i] = 0;
        }
        
        MPConSeguroPopular = 0;
        MSSConSeguroPopular = 0;
        HPConSeguroPopular = 0;
        HSSConSeguroPopular = 0;
        ConProspera = 0;
        PPPrimerVezCount = 0;
        PPSubSecuenteCount = 0;
        PPSP = 0;
    }

    public static void GenTablaDePersonas() {
        DefaultTableModel tableModel = (DefaultTableModel) Recorder.TablaGnral.getModel();
        for (int i = 0; i < ControlP; i++) {
            String Renglones[] = {Consultas.Personas[i].getSex(), Consultas.Personas[i].getAge(), Consultas.Personas[i].getFreq(), Consultas.Personas[i].getCover(),
                 Consultas.Personas[i].getPros(), Consultas.Personas[i].getDerHab(), Consultas.Personas[i].getSeguro(), Consultas.Personas[i].getPProg()};
            tableModel.addRow(Renglones);
        }
        setCellRender(Recorder.TablaGnral);
    }

    public void GenTablaDeTotales() {
        DefaultTableModel TGnral = (DefaultTableModel) TablaDeTotales.tablaTotal.getModel();
        for (int i = 0; i < ControlP; i++) {
            if (Personas[i].getAge().equalsIgnoreCase("< 1 Año")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[0]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[0]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[0]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[0]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[0]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[0]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[0]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[0]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[0]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[0]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("1 Año")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[1]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[1]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[1]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[1]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[1]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[1]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[1]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[1]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[1]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[1]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("2-4 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[2]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[2]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[2]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[2]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[2]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[2]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[2]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[2]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[2]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[2]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("5-9 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[3]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[3]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[3]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[3]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[3]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[3]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[3]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[3]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[3]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[3]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("10-14 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[4]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[4]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[4]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[4]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[4]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[4]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[4]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[4]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[4]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[4]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("15-19 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[5]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[5]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[5]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[5]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[5]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[5]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[5]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[5]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[5]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[5]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("20-29 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[6]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[6]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[6]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[6]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[6]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[6]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[6]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[6]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[6]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[6]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("30-49 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[7]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[7]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[7]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[7]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[7]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[7]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[7]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[7]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[7]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[7]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("50-59 Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[8]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[8]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[8]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[8]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[8]++;
                    }
                } else{ 
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[8]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[8]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[8]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[8]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[8]++;
                    }
                }
            } else if (Personas[i].getAge().equalsIgnoreCase("60 y más Años")) {
                if (Personas[i].getSex().equalsIgnoreCase("Mujer")) {
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        MPrimerVez[9]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[9]++;
                            MPConSeguroPopular++;
                        }
                    } else {
                        MSubSecuente[9]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            MSeguroPopular[9]++;
                            MSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        MPorAño[9]++;
                    }
                } else{
                    if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                        HPrimerVez[9]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[9]++;
                            HPConSeguroPopular++;
                        }
                    } else {
                        HSubSecuente[9]++;
                        if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                            HSeguroPopular[9]++;
                            HSSConSeguroPopular++;
                        }
                    }
                    if(Personas[i].getCover().equals("Primera vez en el año")){
                        HPorAño[9]++;
                    }
                }
            }
            if (Personas[i].getFreq().equalsIgnoreCase("Primera vez")) {
                if (Personas[i].getPProg().equalsIgnoreCase("Enfermedades Transmisibles")) {
                    PPPrimerVez[0]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Cronico Degenerativas")) {
                    PPPrimerVez[1]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Otras Enfermedades")) {
                    PPPrimerVez[2]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("A Sanos")) {
                    PPPrimerVez[3]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Planificacion Familiar")) {
                    PPPrimerVez[4]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Bucal")) {
                    PPPrimerVez[5]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Mental")) {
                    PPPrimerVez[6]++;
                }
            } else if (Personas[i].getPProg().equalsIgnoreCase("Enfermedades Transmisibles")) {
                PPSubSecuente[0]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("Cronico Degenerativas")) {
                PPSubSecuente[1]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("Otras Enfermedades")) {
                PPSubSecuente[2]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("A Sanos")) {
                PPSubSecuente[3]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("Planificacion Familiar")) {
                PPSubSecuente[4]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Bucal")) {
                PPSubSecuente[5]++;
            } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Mental")) {
                PPSubSecuente[6]++;
            }
            if (Personas[i].getSeguro().equalsIgnoreCase("Seguro Popular")) {
                if (Personas[i].getPProg().equalsIgnoreCase("Enfermedades Transmisibles")) {
                    SPPrograma[0]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Cronico Degenerativas")) {
                    SPPrograma[1]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Otras Enfermedades")) {
                    SPPrograma[2]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("A Sanos")) {
                    SPPrograma[3]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Planificacion Familiar")) {
                    SPPrograma[4]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Bucal")) {
                    SPPrograma[5]++;
                } else if (Personas[i].getPProg().equalsIgnoreCase("Salud Mental")) {
                    SPPrograma[6]++;
                }
            }
            if (Personas[i].getRef().equalsIgnoreCase("Referido")) {
                PReferidos[0]++;
            } else if (Personas[i].getRef().equalsIgnoreCase("Contrarreferido")) {
                PReferidos[1]++;
            }
            if (Personas[i].getDerHab().equalsIgnoreCase("IMSS")) {
                PDerHab[0]++;
            } else if (Personas[i].getDerHab().equalsIgnoreCase("ISSSTE")) {
                PDerHab[1]++;
            } else if (Personas[i].getDerHab().equalsIgnoreCase("SMNG")) {
                PDerHab[2]++;
            } else if (Personas[i].getDerHab().equalsIgnoreCase("Otras")) {
                PDerHab[3]++;
            }
            if (Personas[i].getPros().equalsIgnoreCase("Prospera")) {
                ConProspera++;
            }
        }
        MConSeguroPopular = 0;
        HConSeguroPopular = 0;
        Primerizas = 0;
        MSubsecuentes = 0;
        Primerizos = 0;
        HSubsecuentes = 0;
        PPPrimerVezCount = 0;
        PPSubSecuenteCount = 0;
        PPSP = 0;
        int TMPorAño = 0, THPorAño = 0;
        for (int i = 0; i < 10; i++) {
            TMPorAño = TMPorAño + MPorAño[i];
            THPorAño = THPorAño + HPorAño[i];
        }
        for (int i = 0; i < 10; i++) {
            MConSeguroPopular = MConSeguroPopular + MSeguroPopular[i];
            HConSeguroPopular = HConSeguroPopular + HSeguroPopular[i];
            Primerizas = Primerizas + MPrimerVez[i];
            MSubsecuentes = MSubsecuentes + MSubSecuente[i];
            Primerizos = Primerizos + HPrimerVez[i];
            HSubsecuentes = HSubsecuentes + HSubSecuente[i];
        }
        for (int i = 0; i < 7; i++) {
            PPPrimerVezCount = PPPrimerVezCount + PPPrimerVez[i];
            PPSubSecuenteCount = PPSubSecuenteCount + PPSubSecuente[i];
            PPSP = PPSP + SPPrograma[i];
        }
        Mujeres = Primerizas + MSubsecuentes;
        Hombres = Primerizos + HSubsecuentes;
        String HeaderM[] = {String.valueOf(Mujeres) + "_Mujeres", String.valueOf(Primerizas) + "_Primera vez",
            String.valueOf(MSubsecuentes) + "_Subsecuente", "", String.valueOf(TMPorAño) + "_Primera vez en el año"};
        TGnral.addRow(HeaderM);
        for (int i = 0; i < 10; i++) {
            String HeaderMapM[] = {"", String.valueOf(MPrimerVez[i]), String.valueOf(MSubSecuente[i]),
                String.valueOf(MSeguroPopular[i]), String.valueOf(MPorAño[i]), Edades[i]};
            TGnral.addRow(HeaderMapM);
        }
        String n[] = null;
        TGnral.addRow(n);
        String HeaderMSP[] = {"", String.valueOf(MPConSeguroPopular), String.valueOf(MSSConSeguroPopular), String.valueOf(MConSeguroPopular) + "_Seguro Popular"};
        TGnral.addRow(HeaderMSP);
        TGnral.addRow(n);
        String HeaderH[] = {String.valueOf(Hombres) + "_Hombres", String.valueOf(Primerizos) + "_Primera vez",
            String.valueOf(HSubsecuentes) + "_Subsecuente", "", String.valueOf(THPorAño) + "_Primera vez en el año"} ;
        TGnral.addRow(HeaderH);
        for (int i = 0; i < 10; i++) {
            String HeaderMapH[] = {"", String.valueOf(HPrimerVez[i]), String.valueOf(HSubSecuente[i]),
                String.valueOf(HSeguroPopular[i]), String.valueOf(HPorAño[i]), Edades[i]};
            TGnral.addRow(HeaderMapH);
        }
        TGnral.addRow(n);
        String HeaderHSP[] = {"", String.valueOf(HPConSeguroPopular), String.valueOf(HSSConSeguroPopular), String.valueOf(HConSeguroPopular) + "_Seguro Popular"};
        TGnral.addRow(HeaderHSP);
        TGnral.addRow(n);//Se agrega un renglon vacio
        String ProRow[] = {String.valueOf(ConProspera) + "_Con Prospera", String.valueOf(PReferidos[0]) + "_Referidos", String.valueOf(PReferidos[1]) + "_Contrareferidos"};
        TGnral.addRow(ProRow);
        String DerHabRow[] = {String.valueOf(PDerHab[0]) + "_IMSS", String.valueOf(PDerHab[1]) + "_ISSSTE", String.valueOf(PDerHab[2]) + "_SMNG", String.valueOf(PDerHab[3]) + "_Otras"};
        TGnral.addRow(DerHabRow);
        TGnral.addRow(n);//Se agrega un renglon vacio
        String HeaderPorProg[] = {"", String.valueOf(PPPrimerVezCount) + "_Primera Vez", String.valueOf(PPSubSecuenteCount) + "_Subsecuente", String.valueOf(PPSP) + "_Seguro Popular"};
        TGnral.addRow(HeaderPorProg);
        for (int i = 0; i < 7; i++) {
            String HeaderMapPProg[] = {"", String.valueOf(PPPrimerVez[i]), String.valueOf(PPSubSecuente[i]),
                String.valueOf(SPPrograma[i]), Variables[i]};
            TGnral.addRow(HeaderMapPProg);
        }
        TGnral.addRow(n);
        setCellRender(TablaDeTotales.tablaTotal);
    }

    public static void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRender());
        }
    }
}
