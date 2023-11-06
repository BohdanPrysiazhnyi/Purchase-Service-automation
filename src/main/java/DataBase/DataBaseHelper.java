package DataBase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageFactory.BasePage;
import pageFactory.LoginPage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {



    DBWorker dbWorker = new DBWorker();
    public String selectNonFrozenSalesOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM edi_sales_orders " +
                        "WHERE frozen = 0 " +
                        "AND step = 'CONFIRMATION' " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }
    private String selectIdOfSingleRecord(String querySelect) {
        String resultId = "";
        try {
            Statement st = dbWorker.getConnection().createStatement();
            ResultSet queryResult = st.executeQuery(querySelect);
            while (queryResult.next()) {
                resultId = String.valueOf(queryResult.getInt(1));
            }
        } catch (SQLException e) {
        } finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
            }
        }
        return resultId;
    }

    public String selectFrozenSalesOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM edi_sales_orders " +
                        "WHERE frozen = 1 " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }

    public String selectNonLockedSalesOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM edi_sales_orders " +
                        "WHERE locked_by_id IS NULL AND locked_until IS NULL " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }

    public String selectPS3NotSupportedPurchaseOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM nav_purchase_orders " +
                        "WHERE vendor_no IN ('52447919', '58620436', 'SCHOU', '5432232', '5461660', 'TVILUM', '400-5963', " +
                        "'8608861', 'DEARSAM', 'VIDAXL', 'CARPETVISTA', 'VIDAXL-NO', 'VIDAXL-DK', 'VIDAXL-FI')" +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }

    public String selectPS3NotSupportedPurchaseOrderInStatus(String poStatus) {
        String querySelect =
                "SELECT id " +
                        "FROM nav_purchase_orders " +
                        "WHERE vendor_no IN ('52447919', '58620436', 'SCHOU', '5432232', '5461660', 'TVILUM', '400-5963', " +
                        "'8608861', 'DEARSAM', 'VIDAXL', 'CARPETVISTA', 'VIDAXL-NO', 'VIDAXL-DK', 'VIDAXL-FI')" +
                        "AND step NOT IN ('CANCEL', 'INVOICE', 'DISPATCH') AND cancel_status IS NULL " +
                        "AND step = '" + poStatus + "' " +
                        "AND cancel_status IS NULL " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }


//    public void updateUserName(String userName) {
//        String queryUpdate =
//                "UPDATE user_accounts " +
//                        "SET username='" + userName + "', " +
//                        "password='$2y$10$dwkJtHhhQ9W5sDXNh1Wz3Of2p3dLY5QmtiCbTFOcKaMkaxACDrsia' " +
//                        "WHERE email='" + userEmail + "' " +
//                        "ORDER BY id DESC LIMIT 1;";
//        updateTable(queryUpdate);
//
//        closeSQLConnection();
//    }

    // Important! Each time calling updateTable method, use directly closeSQLConnection()
    private void updateTable(String sqlQuery) {
        //logger.info("Start method updateSingleRow");
        int rowsUpdated = 0;
        try {
            Statement st = dbWorker.getConnection().createStatement();
            //logger.info("sqlQuery: " + sqlQuery);
            rowsUpdated = st.executeUpdate(sqlQuery);
        } catch (SQLException e) {
        }
    }

    public void closeSQLConnection () {
        try {
            dbWorker.getConnection().close();
        } catch (SQLException e) {
        }
    }

//    public String getAccountId () {
//        String querySelect =
//                "SELECT id " +
//                        "FROM user_accounts " +
//                        "WHERE email='" + userEmail + "';";
//        String id = selectIdOfSingleRecord(querySelect);
//        logger.info("test user account id is: " + id);
//        return id;
//    }

    public void updateAccountWithRequiredRoles (String accountId) {
        deleteExistingPermissions(accountId);
        setNewPermissions(accountId);

        closeSQLConnection();
    }

    private void deleteExistingPermissions(String accountId) {
        String queryDelete =
                "DELETE FROM user_accounts_to_roles " +
                        "WHERE user_id  = " + accountId + ";";
        updateTable(queryDelete);
    }

    private void setNewPermissions(String accountId) {
        for (int roleId = 1; roleId <= 18; roleId++) {
            if (roleId == 5 | roleId == 7) {
                continue;
            }
            String queryInsert =
                    "INSERT INTO user_accounts_to_roles (user_id, role_id) " +
                            "VALUES (" + accountId + "," + roleId + ");";
            updateTable(queryInsert);
        }
    }

    public String selectNotCanceledPurchaseOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM nav_purchase_orders " +
                        "WHERE vendor_no IN ('52447919', '58620436', 'SCHOU', '5432232', '5461660', 'TVILUM', '400-5963', " +
                        "'8608861', 'DEARSAM', 'VIDAXL', 'CARPETVISTA', 'VIDAXL-NO', 'VIDAXL-DK', 'VIDAXL-FI')" +
                        "AND step NOT IN ('CANCEL', 'INVOICE', 'DISPATCH') AND cancel_status IS NULL " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }

    public String selectLastSalesReturnOrder() {
        String querySelect =
                "SELECT id " +
                        "FROM edi_sales_return_orders " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectIdOfSingleRecord(querySelect);
    }

    public String selectNameOfLastCustomer() {
        String querySelect =
                "SELECT name " +
                        "FROM edi_customers " +
                        "ORDER BY id DESC LIMIT 1;";
        return selectAnyTextFieldForSingleRecord(querySelect);
    }

    private String selectAnyTextFieldForSingleRecord(String querySelect) {
        String resultString = "";
        try {
            Statement st = dbWorker.getConnection().createStatement();
            ResultSet queryResult = st.executeQuery(querySelect);
            while (queryResult.next()) {
                resultString = queryResult.getString(1);
            }
        } catch (SQLException e) {
        } finally {
            try {
                dbWorker.getConnection().close();
            } catch (SQLException e) {
            }
        }
        return resultString;
    }

    public String selectSupplierInfoLink(String mid) {
        String querySelect =
                "SELECT supplier_info_link " +
                        "FROM af_manufacturers_information " +
                        "WHERE mid = " + mid + ";";
        return selectAnyTextFieldForSingleRecord(querySelect);
    }






}
