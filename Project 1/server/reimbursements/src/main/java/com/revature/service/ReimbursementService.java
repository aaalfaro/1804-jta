package com.revature.service;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.CreateReimbursementModel;
import com.revature.model.MyReimbursementReturn;
import com.revature.model.ReimbursementTable;

import java.util.List;

public class ReimbursementService {
    private static ReimbursementDao dao = ReimbursementDaoImpl.getInstance();

    public static boolean createReimbursement (CreateReimbursementModel cm){
        return dao.createReimbursement(cm);
    }

    public static List<MyReimbursementReturn> getReimbursementsByUser(String username) {
        return dao.getRequestedReimbursementsByUser(username);
    }

    public static List<ReimbursementTable> getAllReimbursements() {
        return dao.getAllReimbursements();
    }
}