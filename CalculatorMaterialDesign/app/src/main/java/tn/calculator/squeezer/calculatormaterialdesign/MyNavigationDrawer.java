package tn.calculator.squeezer.calculatormaterialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialSectionListener;

/**
 * Created by Wael on 05/08/2015.
 */
public class MyNavigationDrawer extends MaterialNavigationDrawer {
    @Override
    public void init(Bundle bundle) {
        this.disableLearningPattern();
        setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
        MaterialAccount account = new MaterialAccount(this.getResources(), "Ouni Wael", "waelounie@gmail.com", R.drawable.profile, R.drawable.abc_btn_default_mtrl_shape);
        this.addAccount(account);
        this.addSubheader("Sections :");
        MaterialSection section1 = newSection("My calculator design ", new section3Fragment());
        MaterialSection section2 = newSection("Test my material calulator", new Intent(this, Calculator.class));
        addSection(section1);
        addSection(section2);

        this.addDivisor();
        this.addSubheader("Guide :");
        MaterialSection help = newSection("About us", new Intent(this, help.class));

        addBottomSection(help);
        section1.setSectionColor(Color.red(55), 5);
        section2.setSectionColor(Color.blue(55), 15);
        help.setSectionColor(Color.GRAY, 15);
        section2.setNotifications(2);

        final int notifications = section1.getNotifications();

        this.setAccountListener(new MaterialAccountListener() {
            @Override
            public void onAccountOpening(MaterialAccount materialAccount) {
                Toast.makeText(getApplicationContext(), "You can't change  this account ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChangeAccount(MaterialAccount materialAccount) {

            }
        });

        section1.setOnClickListener(new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection materialSection) {
                Toast.makeText(getApplicationContext(), "Wait for the course of notification" + notifications, Toast.LENGTH_LONG).show();
            }
        });
    }
}
