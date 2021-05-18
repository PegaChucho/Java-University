package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@RequestScoped
@Named
public class ColoniaHelper {

    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();

        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Zona Escolar", 7230);
        colonias.add(colonia);

        colonia = new Colonia(coloniaId++, "Arbolillo", 7240);
        colonias.add(colonia);

        colonia = new Colonia(coloniaId++, "San Lucas patoni", 7250);
        colonias.add(colonia);

        colonia = new Colonia(coloniaId++, "Loma la Palma", 7260);
        colonias.add(colonia);

        return colonias;
    }

    public int getColoniaPorNombre(String nombreColonia) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();

        for (Colonia colonia : colonias) {
            if (colonia.getNombreColonia().equals(nombreColonia)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    public int getColoniaPorCP(int codigoPostal) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectitems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
           SelectItem selectItem= new SelectItem(colonia.getColoniaId(), colonia.getNombreColonia());
           selectitems.add(selectItem);
        }
        return selectitems;

    }
}
