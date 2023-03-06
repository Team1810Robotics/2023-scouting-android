package com.example.scouting_2023;

public class DataModelDAO {

        private static DataModelDAO instance;
        private DataModel myDataObject;

        private DataModelDAO() {
            myDataObject = new DataModel();
        }

        public static synchronized DataModelDAO getInstance() {
            if (instance == null) {
                instance = new DataModelDAO();
            }
            return instance;
        }

    public static void setMyDataObject(DataModel dataObject) {
        getInstance().myDataObject = dataObject;
    }
        public DataModel getMyDataObject() {
            return myDataObject;
        }


}
