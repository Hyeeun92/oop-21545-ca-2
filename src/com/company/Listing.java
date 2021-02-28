package com.company;
import com.company.models.Passenger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Listing extends JFrame {

    public Listing() {

        String[] columns = new String[]{
                "name", "gender", "age"
        };

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model);

        Queries queries = new Queries();

        List<Passenger> passengers =  queries.getPassengersByGender("female");

        for(Passenger p : passengers) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }


        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);



    }
}
