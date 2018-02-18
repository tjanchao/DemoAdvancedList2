package be.ehb.demoadvancedlist.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import be.ehb.demoadvancedlist.R;
import be.ehb.demoadvancedlist.model.Fruit;

/**
 * Created by Q on 16-2-2018.
 */

public class FruitListAdapter extends BaseAdapter {

    private ArrayList<Fruit> fruityList;

    //de context i.e. scherm waar ik al mijn data ga uittekenen: in welk scherm het wordt getekend
    private Activity context;

    //viewholder pattern
    private static class ViewHolder {
        TextView tvName;
        TextView tvPrice;

    }

    public FruitListAdapter(ArrayList<Fruit> fruityList, Activity context) {
        this.fruityList = fruityList;
        this.context = context;
    }

    //hoeveel rijen
    @Override
    public int getCount() {
        return fruityList.size();
    }

    //welke rij
    @Override
    public Object getItem(int position) {
        return fruityList.get(position);
    }
    //vraag id van rij op; vooral te gebruiken als je gegevens uit een databank haalt; je kunt hier in deze oefening return 0 laten of return position
    @Override
    public long getItemId(int position) {
        return 0;
    }
    //onze rij
    @Override            //welke rij    //onze layout       //onze ListView
    public View getView(int position, View convertView, ViewGroup parent) {

        //ViewHolder Rij is vergelijkbaar met cell in Swift. --> eigenlijk zoals de opbouw van 1 prototype cell zoals in Swift
        ViewHolder rij;

        if (convertView == null) {
            //als layout nog nergens aangemaakt is (i.e. bestaat nog niet, dus null), dan hier aanmaken: onze convertView
            convertView = context.getLayoutInflater().inflate(R.layout.list_item_fruit, null);

            rij = new ViewHolder();
            rij.tvName = convertView.findViewById(R.id.tv_name);
            rij.tvPrice = convertView.findViewById(R.id.tv_price);

            //geef object mee aan convertView
            convertView.setTag(rij);

        }else {
            //layout bestond, alles ok
            rij = (ViewHolder) convertView.getTag();
        }

        //onze rij opvullen
        Fruit currentFruit = fruityList.get(position);

        rij.tvName.setText(currentFruit.getName());
        rij.tvPrice.setText(""+ currentFruit.getPrice()); //of String.format("%f", currentFruit.getPrice())


        return convertView;
    }
}
