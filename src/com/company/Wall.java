package com.company;


import java.util.ArrayList;
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
        for (Block block:blocks) {

            if (block.getColor().equals(color)) {
                return Optional.ofNullable(block);
            }

        }
        return Optional.empty();
    }


    public List findBlocksByMaterial(String material) {
        ArrayList<Block> blocksByMaterial = new ArrayList<>();
        for (Block block:blocks) {
            if (block.getMaterial().equals(material)) {
                blocksByMaterial.add(block);
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
