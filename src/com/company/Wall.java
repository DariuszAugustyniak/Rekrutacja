package com.company;


import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks; //zakładam że wszystkie elementy tej listy implementuja interfejs Block lub CompositeBlock


    public Optional findBlockByColor(String color) {
        for (int i = 0; i < blocks.size(); i++) {

            if (blocks.get(i).getColor().equals(color)) {
                return Optional.ofNullable(blocks.get(i));
            }

            if (blocks.get(i) instanceof Block) {

            }
        }
        return Optional.ofNullable(null);
    }


    public List findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = null;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getMaterial().equals(material)) {
                blocksByMaterial.add(blocks.get(i));
            }
        }
        return blocksByMaterial;
    }


    public int count() {
        int i = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                i = i + ((CompositeBlock) block).getBlocks().size();
            } else {
                i++;
            }
        }
        return i;
    }

}


interface Block {
    String getColor();

    String getMaterial();
}

interface CompositeBlock extends Block {
    List getBlocks();
}
