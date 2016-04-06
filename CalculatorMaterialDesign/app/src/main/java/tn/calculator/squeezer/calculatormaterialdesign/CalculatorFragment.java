package tn.calculator.squeezer.calculatormaterialdesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * A placeholder fragment containing a simple view.
 */
public class CalculatorFragment extends Fragment {
    EditText editText;
    ButtonRectangle b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPlus, bSous, bMoins, bDiv, bPourcent, bC, bFois, bPoint, bParent;
    ButtonFlat bEgual;

    public CalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        editText = (EditText) view.findViewById(R.id.result);
        b1 = (ButtonRectangle) view.findViewById(R.id.button1);
        b2 = (ButtonRectangle) view.findViewById(R.id.button2);
        b3 = (ButtonRectangle) view.findViewById(R.id.button3);
        b4 = (ButtonRectangle) view.findViewById(R.id.button4);
        b5 = (ButtonRectangle) view.findViewById(R.id.button5);
        b6 = (ButtonRectangle) view.findViewById(R.id.button6);
        b7 = (ButtonRectangle) view.findViewById(R.id.button7);
        b8 = (ButtonRectangle) view.findViewById(R.id.button8);
        b9 = (ButtonRectangle) view.findViewById(R.id.button9);
        b0 = (ButtonRectangle) view.findViewById(R.id.button0);

        return view;
    }


}
