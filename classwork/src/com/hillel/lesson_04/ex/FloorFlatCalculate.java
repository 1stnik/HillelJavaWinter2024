package com.hillel.lesson_04.ex;

/*
В N этажного жилом доме M квартир.
Определить, на каком этаже и в каком подъезде
находится квартира с заданным номером.
 4 квартиры на этаже
 */
// 9 этажей 108 квартир
public class FloorFlatCalculate {

    /*
    nFlat = 108;
    nFloorPerBlock = 9;
    nFlatPerFloor = 4;
    blockNumber = nFlat / (nFloorPerBlock * nFlatPerFloor)
    108 / 36 = 3;
     */

    static int  nFlat = 108;
    static int nFloorPerBlock = 9;
    static int nFlatPerFloor = 4;

    private static int calculateBlockNumber(int flatNumber){
        int tmp = nFlatPerFloor * nFloorPerBlock;
        System.out.println(tmp);
        System.out.println(flatNumber / tmp);
        return 0;
    }

    private static int calculateFloorNumber(int flatNumber){
        return 0;
    }

    public static void main(String[] args) {
        int nKv=324;
        int nEtazh=9;
        int nPerFloor=4;
        int appNo=-100;


        if (appNo <= 0 || appNo > nKv)
            throw new RuntimeException("incorrect input values ...");

        int floor=((appNo - 1 )%(nPerFloor*nEtazh))/nPerFloor+1;
        int podjezd=(appNo - 1)/(nPerFloor*nEtazh)+1;

        System.out.println("Floor "+floor);
        System.out.println("Podjezd "+podjezd);
    }

}
