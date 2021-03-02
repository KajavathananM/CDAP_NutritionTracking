package com.example.mkvat.hospitalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "HospitalDB";


    // Doctor table name
    private static final String TABLE_DOCTORS = "Doctor";

    // Doctor Table Columns names
    private static final String KEY_docid = "docid";
    private static final String KEY_docname = "docname";
    private static final String KEY_type = "type";
    private static final String KEY_centre1 = "centre1";
    private static final String KEY_centre2 = "centre2";
    private static final String KEY_docCharge = "docCharge";


    private static final String[] COLUMNS1 = {KEY_docid, KEY_docname, KEY_type, KEY_centre1, KEY_centre2,KEY_docCharge};

    // LabRecieptData table name
    private static final String TABLE_LabReceiptData = "LabReceipt";

    // LabReceipt Table Columns names
    private static final String KEY_refid = "refid";
    private static final String KEY_patname = "name";
    private static final String KEY_patcontactNo = "contactno";
    private static final String KEY_patemail= "email";
    private static final String KEY_patnic= "nic";
    private static final String KEY_date= "date";
    private static final String KEY_reportType= "rType";
    private static final String KEY_reportCharge= "rCharge";
    private static final String KEY_hospital= "hospital";


    private static final String[] COLUMNS2 = {KEY_refid ,KEY_patname , KEY_patcontactNo,  KEY_patemail, KEY_patnic,KEY_date,KEY_reportType,KEY_reportCharge,KEY_hospital};

    // DrRecieptData table name
    private static final String TABLE_DrReceiptData = "DrReceipt";


    // DrReceipt Table Columns names
    private static final String KEY_room ="room";
    private static final String KEY_bookingCharges ="bookCharge";
    private static final String KEY_hospitalCharges ="hospitalCharge";
    private static final String KEY_doctorCharges ="doctorCharge";
    private static final String KEY_totalCharges ="totalCharge";




    private static final String[] COLUMNS4 = {KEY_refid ,KEY_patname , KEY_patcontactNo,  KEY_patemail, KEY_patnic, KEY_docname,KEY_hospital,KEY_room,KEY_bookingCharges,
            KEY_hospitalCharges,KEY_doctorCharges,KEY_totalCharges};

    //Report Table name
    private static final String TABLE_Reports = "Report";

   //Report column names
    private static final String KEY_reportId = "rId";
    private static final String KEY_ReportType = "rType";
    private static final String  KEY_ReportCharge="rCharge";

    private static final String[] COLUMNS3 = { KEY_reportId ,KEY_ReportType, KEY_ReportCharge};

    //HospitalCost table name
    private static final String TABLE_hospitalCost = "HospitalCost";

    //HospitalCost column names
    private static final String KEY_hospId = "hospitalId";
    private static final String KEY_hospName = "hospitalName";
    private static final String  KEY_bookCharge="bookingCharge";
    private static final String  KEY_hospCharge="hospitalCharge";

    private static final String[] COLUMNS5 = { KEY_hospId ,KEY_hospName, KEY_bookCharge,KEY_hospCharge};


    // Payer table name
    private static final String TABLE_Payers = "Payer";

    //Payer column names
    private static final String KEY_payerId = "payerId";
    private static final String KEY_payerName = "payerName";
    private static final String  KEY_payercontactNo="contactNumber";
    private static final String  KEY_payeremail="email";
    private static final String  KEY_payerNIC="NIC";

    private static final String[] COLUMNS6 = {KEY_payerId  ,KEY_payerName,KEY_payercontactNo,KEY_payeremail, KEY_payerNIC};

    private static final String TABLE_Payments = "Payment";

    //Payer column names
    private static final String KEY_payId = "payId";
    private static final String key_patientName="patientName";
    private static final String  KEY_paymentType="paymentType";
    private static final String  KEY_branchType="branch";
    private static final String  KEY_AmountValue="amount";

    private static final String[] COLUMNS7 = {KEY_payId,key_patientName ,KEY_paymentType,KEY_branchType,KEY_refid, KEY_AmountValue};



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table


        String CREATE_Doc_TABLE = "CREATE TABLE Doctor ( " +
                "docid  TEXT PRIMARY KEY , " +
                "docname TEXT, " +
                "type TEXT, " +
                "centre1 TEXT, " +
                "centre2 TEXT, " +
                "docCharge TEXT )";


        String CREATE_Report_TABLE = "CREATE TABLE Report ( " +
                "rId  TEXT PRIMARY KEY , " +
                "rType TEXT, " +
                "rCharge TEXT )";

        String CREATE_Labreceipt_TABLE = "CREATE TABLE LabReceipt ( " +
                "refid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "contactno TEXT, " +
                "email TEXT, " +
                "nic TEXT, " +
                "date TEXT, " +
                "rType TEXT, " +
                "rCharge TEXT, " +
                "hospital TEXT )";

        String CREATE_DrReceipt_TABLE = "CREATE TABLE DrReceipt ( " +
                "refid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "contactno TEXT, " +
                "email TEXT, " +
                "nic TEXT, " +
                "docname TEXT, " +
                "hospital TEXT, " +
                "room TEXT, " +
                "bookCharge TEXT, " +
                "hospitalCharge TEXT, " +
                "doctorCharge TEXT, " +
                "totalCharge TEXT )";

        String CREATE_hospitalCost_TABLE = "CREATE TABLE HospitalCost ( " +
                "hospitalId TEXT PRIMARY KEY , " +
                "hospitalName TEXT, " +
                "bookingCharge TEXT, " +
                "hospitalCharge TEXT )";

        String CREATE_Payers_TABLE = "CREATE TABLE Payer ( " +
                "payerId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "payerName TEXT, " +
                "contactNumber TEXT, " +
                "email TEXT, " +
                "NIC TEXT )";
        String CREATE_Payments_TABLE = "CREATE TABLE Payment ( " +
                "payId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "patientName TEXT, " +
                "paymentType TEXT, " +
                "branch TEXT, " +
                "refid TEXT, " +
                "amount TEXT )";

        db.execSQL(CREATE_Doc_TABLE);
        db.execSQL(CREATE_Report_TABLE);
        db.execSQL(CREATE_Labreceipt_TABLE);
        db.execSQL(CREATE_DrReceipt_TABLE);
        db.execSQL(CREATE_hospitalCost_TABLE);
        db.execSQL(CREATE_Payers_TABLE);
        db.execSQL(CREATE_Payments_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Doctor");
        db.execSQL("DROP TABLE IF EXISTS Report");
        db.execSQL("DROP TABLE IF EXISTS LabReceipt");
        db.execSQL("DROP TABLE IF EXISTS DrReceipt");
        db.execSQL("DROP TABLE IF EXISTS HospitalCost");
        db.execSQL("DROP TABLE IF EXISTS Payer");
        db.execSQL("DROP TABLE IF EXISTS Payment");


        // create all tables
        this.onCreate(db);
    }
    //---------------------------------------------------------------------




    public void addDoctor(Doctor doc) {
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_docid, doc.getDocId());
        values.put(KEY_docname, doc.getDocName());
        values.put(KEY_type, doc.getType());
        values.put(KEY_centre1, doc.getCentre1());
        values.put(KEY_centre2, doc.getCentre2());
        values.put(KEY_docCharge,doc.getDocCharge());

        // 3. insert
        db.insert(TABLE_DOCTORS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public Doctor getDoctor(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_DOCTORS, // a. table
                        COLUMNS1, // b. column names
                        "docname   = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build doctor object
        Doctor doctor = new Doctor();
        doctor.setDocId(cursor.getString(0));
        doctor.setDocName(cursor.getString(1));
        doctor.setType(cursor.getString(2));
        doctor.setCentre1(cursor.getString(3));
        doctor.setCentre2(cursor.getString(4));
        doctor.setDocCharge(Double.parseDouble(cursor.getString(5)));

        return doctor;
    }
    public void addReport(Report rep) {

        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_reportId, rep.getrId());
        values.put(KEY_ReportType, rep.getrType());
        values.put(KEY_ReportCharge, rep.getrCharge());



        // 3. insert
        db.insert(TABLE_Reports, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public Report getReport(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_Reports, // a. table
                        COLUMNS3, // b. column names
                        "rType   = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        Report report = new Report();

        report.setrId(cursor.getString(0));
        report.setrType(cursor.getString(1));
        report.setrCharge(Double.parseDouble(cursor.getString(2)));



        return report;
    }
    public void createLabBill(LabReceiptData l) {
        //Log.d("addBook", book.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_patname, l.getPatientName());
        values.put(KEY_patcontactNo, l.getContactNo());
        values.put(KEY_patemail, l.getEmail());
        values.put(KEY_patnic,l.getNic());
        values.put(KEY_date,l.getDate());
        values.put(KEY_reportType,l.getReportType());
        values.put(KEY_reportCharge,l.getReportCharge());
        values.put(KEY_hospital,l.getHospital());

        // 3. insert
        db.insert( TABLE_LabReceiptData , // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public LabReceiptData getLabReceipt(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_LabReceiptData, // a. table
                        COLUMNS2, // b. column names
                        "name   = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
            LabReceiptData l = new LabReceiptData();
        //doctor.setDocId(Integer.parseInt(cursor.getString(0)));
        l.setRefid(Integer.parseInt(cursor.getString(0)));
        l.setPatientName(cursor.getString(1));
        l.setContactNo(cursor.getString(2));
        l.setEmail(cursor.getString(3));
        l.setNic(cursor.getString(4));
        l.setDate(cursor.getString(5));
        l.setReportType(cursor.getString(6));
        l.setReportCharge(Double.parseDouble(cursor.getString(7)));
        l.setHospital(cursor.getString(8));



        return l;
    }
    public LabReceiptData getLabReceiptById(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_LabReceiptData, // a. table
                        COLUMNS2, // b. column names
                        "refid   = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        LabReceiptData l = new LabReceiptData();
        //doctor.setDocId(Integer.parseInt(cursor.getString(0)));
        l.setRefid(Integer.parseInt(cursor.getString(0)));
        l.setPatientName(cursor.getString(1));
        l.setContactNo(cursor.getString(2));
        l.setEmail(cursor.getString(3));
        l.setNic(cursor.getString(4));
        l.setDate(cursor.getString(5));
        l.setReportType(cursor.getString(6));
        l.setReportCharge(Double.parseDouble(cursor.getString(7)));
        l.setHospital(cursor.getString(8));



        return l;
    }
    public void deleteLabBill(LabReceiptData l) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_LabReceiptData,
                KEY_refid+" = ?",
                new String[] { String.valueOf(l.getRefid()) });

        // 3. close
        db.close();



    }
    public int updateLabBill(LabReceiptData l) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("name", l.getPatientName());
        values.put("contactno", l.getContactNo());
        values.put("email",l.getEmail());
        values.put("nic",l.getNic());
        values.put("date",l.getDate());
        values.put("rType", l.getReportType());
        values.put("rCharge", l.getReportCharge());
        values.put("hospital",l.getHospital());

        // 3. updating row
        int i = db.update(TABLE_LabReceiptData, //table
                values, // column/value
                KEY_refid+" = ?", // selections
                new String[] { String.valueOf(l.getRefid() ) }); //selection args

        // 4. close
        db.close();

        return i;

    }


    public void createDrBill(DrReceiptData d) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_patname, d.getPatientName());
        values.put(KEY_patcontactNo, d.getContactNo());
        values.put(KEY_patemail, d.getEmail());
        values.put(KEY_patnic,d.getNic());
        values.put(KEY_docname,d.getDoctorName());
        values.put(KEY_hospital,d.getHospital());
        values.put(KEY_room,d.getRoom());
        values.put(KEY_bookingCharges,d.getbCharges());
        values.put(KEY_hospitalCharges,d.gethCharges());
        values.put(KEY_doctorCharges,d.getdCharges());
        values.put(KEY_totalCharges,d.gettCharges());


        // 3. insert
        db.insert( TABLE_DrReceiptData , // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public DrReceiptData getDrReceipt(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_DrReceiptData, // a. table
                        COLUMNS4, // b. column names
                        "name   = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        DrReceiptData d = new DrReceiptData();
        //doctor.setDocId(Integer.parseInt(cursor.getString(0)));
        d.setRefid(Integer.parseInt(cursor.getString(0)));
        d.setPatientName(cursor.getString(1));
        d.setContactNo(cursor.getString(2));
        d.setEmail(cursor.getString(3));
        d.setNic(cursor.getString(4));
        d.setDoctorName(cursor.getString(5));
        d.setHospital(cursor.getString(6));
        d.setRoom(cursor.getString(7));
        d.setbCharges(Double.parseDouble(cursor.getString(8)));
        d.sethCharges(Double.parseDouble(cursor.getString(9)));
        d.settCharges(Double.parseDouble(cursor.getString(10)));


        return d;
    }
    public void deleteDrBill(DrReceiptData d) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_DrReceiptData,
                KEY_patname+" = ?",
                new String[] { String.valueOf(d.getPatientName()) });

        // 3. close
        db.close();



    }
    public void addDetails(HospitalCost h) {

        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_hospId, h.getHospId());
        values.put(KEY_hospName, h.getHospName());
        values.put(KEY_bookCharge, h.getBookingCharge());
        values.put(KEY_hospCharge, h.getHospCharge());



        // 3. insert
        db.insert(TABLE_hospitalCost, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public  HospitalCost getCostDetails(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query( TABLE_hospitalCost, // a. table
                        COLUMNS5, // b. column names
                        "hospitalName = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build cost object
        HospitalCost h=new HospitalCost();

        h.setHospId(cursor.getString(0));
        h.setHospName(cursor.getString(1));
        h.setBookingCharge(Double.parseDouble(cursor.getString(2)));
        h.setHospCharge(Double.parseDouble(cursor.getString(3)));



        return h;
    }
    public void addPayer(Payer p) {

        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_payerName, p.getPayerName());
        values.put(KEY_payercontactNo,p.getContactNo());
        values.put(KEY_payeremail, p.getEmail());
        values.put(KEY_payerNIC,p.getNic());



        // 3. insert
        db.insert(TABLE_Payers, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public  Payer getPayer(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query( TABLE_Payers, // a. table
                        COLUMNS6, // b. column names
                        "payerName = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build cost object
        Payer p=new Payer();


        p.setPayerName(cursor.getString(1));
        p.setContactNo(cursor.getString(2));
        p.setEmail(cursor.getString(3));
        p.setNic(cursor.getString(4));



        return p;
    }
    public void createPayment(Payment p) {

        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(key_patientName, p.getPatientName());
        values.put(KEY_paymentType,p.getPaymentType());
        values.put( KEY_branchType, p.getBranchType());
        values.put(KEY_refid,p.getRefNo());
        values.put(KEY_AmountValue,p.getAmount());



        // 3. insert
        db.insert(TABLE_Payments, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }
    public  Payment getPayment(String value){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query( TABLE_Payments, // a. table
                        COLUMNS7, // b. column names
                        "patientName = ?", // c. selections
                        new String[] { String.valueOf(value) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build cost object
        Payment p=new Payment();


        p.setPatientName(cursor.getString(1));
        p.setPaymentType(cursor.getString(2));
        p.setBranchType(cursor.getString(3));
        p.setRefNo(cursor.getString(4));
        p.setAmount(Double.parseDouble(cursor.getString(5)));



        return p;
    }

}