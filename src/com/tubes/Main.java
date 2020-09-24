package com.tubes;

import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        int nrow,ncol,dimension;

        boolean exit = false;
	    while(!exit){
            System.out.println("MENU\n" +
                    "1. Sistem Persamaan Linear\n" +
                    "2. Determinan\n" +
                    "3. Matriks Balikan\n" +
                    "4. Interpolasi Polinom\n" +
                    "5. Regresi Linear Berganda\n" +
                    "6. Exit\n");
            Scanner input = new Scanner(System.in);
            int opt = input.nextInt();

            switch (opt){
                case 1:
                    System.out.println("Sistem persamaan linear");
                    System.out.print("Baris: ");
                    nrow = input.nextInt();
                    System.out.print("Kolom: ");
                    ncol = input.nextInt();
                    System.out.println("1. Manual Input\n" +
                            "2. Upload file");
                    Matrix matrixSPL = new Matrix();
                    SPLSolver SPL = new SPLSolver();
                    int ops = input.nextInt();
                    if(ops==1) {
                        matrixSPL.makeMatrix(nrow, ncol);
                        Operations.fillMatrix(matrixSPL);
                    } else if (ops == 2) {
                        // input nama file
                        Scanner inputFileName = new Scanner(System.in);
                        String namaFile = inputFileName.nextLine();
                        System.out.println("Fitur belum tersedia");
                    }
                    System.out.println("1. Metode Eliminasi Gauss\n" +
                            "2. Metode eliminasi Gauss-Jordan\n" +
                            "3. Metode matriks balikan\n" +
                            "4. Kaidah crammer ");
                    int op = input.nextInt();
                    if(op==1) {
                        System.out.println("Metode Eliminasi Gauss");
                        SPL.gaussDriver(matrixSPL);
                    } else if(op==2) {
                        System.out.println("Metode eliminasi Gauss-Jordan");
                    } else if(op==3) {
                        System.out.println("Metode matriks balikan");
                    } else if(op==4) {
                        System.out.println("Kaidah crammer");
                    } else{
                        System.out.println("Input salah");
                    }
                    break;

                case 2:
                    System.out.println("Determinan");
                    System.out.print("Enter the matrix dimension (nxn) : ");
                    dimension = input.nextInt();
                    SquareMatrix matrix = new SquareMatrix();
                    matrix.makeMatrix(dimension);
                    Operations.fillMatrix(matrix);
                    Operations.printMatrix(matrix);
                    double det = Determinant.RowReductionDeterminant(matrix);
                    System.out.println("The determinant value is " + det);
                    det = Determinant.CofactorExpansionDeterminant(matrix);
                    System.out.println("The determinant value is " + det);
                    break;

                case 3:
                    System.out.println("Matriks Balikan");
                    break;

                case 4:
                    System.out.println("Interpolasi polinom");
                    break;

                case 5:
                    System.out.println("Regresi Linear Berganda");
                    break;

                case 6:
                    System.out.println("Exit");
                    break;

                default:
                    exit = true;
            }

        }
    }
}
