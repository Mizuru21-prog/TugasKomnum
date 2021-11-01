import java.util.Scanner;

/**
 * Methode Secant
 * @author Anas Naufal Al-kiram
 * @version 30/10/2021
 */

class Secant 
{

    /**
     * a adalah nilai range bawah
     * b adalah nilai range atas
     * c adalah nilai x yang akan di cari
     * c0 nilai c sebelum berubah
     * fa adalah nilai fungsi ketika dimasukkan range bawah
     * fb adalah nilai fungsi ketika dimasukkan range atas
     * fc adalah nilai fungsi ketika dimasukkan nilai c atau x yang dicari
     * error adalah variabel untuk menampung nilai toleransi
     */
        double a, b, c, c0, fa, fb, fc, error;
    
    /**
     * method Func1 merupakan method yang mengembalikan nilai double
     * @param x parameter x menampung nilai double
     * @return mengembalikan nilai dari fungsi soal pertama
     */
    double Func1(double x)
    {
        return x * Math.exp(-x) + Math.sin(2*x);
    }

    /**
     * method Funct2 merupakan method yang mengembalikan nilai double
     * @param x parameter x menampung nilai double
     * @return mengembalikan nilai dari fungsi soal kedua
     */
    double Func2(double x)
    {
        return Math.cos(x+1) + Math.exp(-x+2);
    }

    /**
     * method Func3 merupakan method yang mengembalikan nilai double
     * @param x parameter x menampung niali double
     * @return mengembalikan nilai dari fungsi soal ketiga
     */
    double Func3(double x)
    {
        return Math.cos(x) - Math.sin(x);
    }

    /**
     * Method alur memiliki tipe void
     * @param isiX1 parameter isiX1 adalah nilai range bawah
     * @param isiX2 parameter isiX2 adalah nilai range atas
     * @param e parameter e adalah nilai dari toleransi galat
     */
    void alur(double isiX1, double isiX2, double e)
    {
        /**
         * variabel i menampung nilai iterasi yang dilakukan
         */
        int i = 0;
        System.out.printf("i "+"a\t"+ "\tb\t"+ "\tc\t"+ "\tfa\t"+ "\tfb\t"+ "\tfc\t"+"\n");
        System.out.println("============================================================================================");

        a = isiX1;
        b = isiX2;
        error = e + 1; // disini error di  tambah 1 untuk dapat masuk ke perulangan while

        if(b == 2.4) // disini kondisi b dipakai karena menjadi pembeda di ketiga soal, untuk soal satu 2.4 
        {  
            while(error>e) // perulangan berjalan karena nilai error awal telah ditambah 1
            {
                fa = Func1(a); // disini diambil nilai dari fungsi range bawah dan disimpan dalam fa
                fb = Func1(b); // disini diambil nilai dari fungsi range atas dan disimpan dam fb
                c0 = c; // c0 dipakai untuk menyimpan nilai awal dari c
                c = b - ((fb*(b-a))/(fb-fa)); // nilai c di cari dengan rumus disamping
                fc = Func1(c); // disini diambil nilai fungsi dari c dan di simpan ke dalam fc
                error = Math.abs((c-c0)/c); // error disini untuk menghentikan perulangan dan nilai c terakhir merupakan
                                            // penyelesaiannya
                System.out.printf("%d  %.5f\t%.5f\t\t%.5f\t\t%.5f   \t%.5f  \t%.5f",i,a,b,c,fa,fb,fc);
                System.out.println();
                a = b; // nilai a akan diganti dengan b
                b = c; // nilai b akan di ganti dengan c
                i++; // iterasi bertambah
            }
                System.out.printf("Akar persamaannya adalah %.5f",c); // menampilkan hasil
                System.out.println();

        }
        else if(b == 3) // untuk soal nomor 2
        { 
            while(error>e)
            {
                fa = Func2(a);
                fb = Func2(b);
                c0 = c;
                c = b - ((fb*(b-a))/(fb-fa));
                fc = Func2(c);
                error = Math.abs((c-c0)/c);
            
                System.out.printf("%d  %.5f\t%.5f\t\t%.5f\t\t%.5f   \t%.5f  \t%.5f",i,a,b,c,fa,fb,fc);
                System.out.println();
                a = b;
                b = c;
                i++;
            }
                System.out.printf("Akar persamaannya adalah %.5f",c);
                System.out.println();
        }
        else if(b == 2) // untuk soal ketiga
        {
            while(error>e)
            {
                fa = Func3(a);
                fb = Func3(b);
                c0 = c;
                c = b - ((fb*(b-a))/(fb-fa));
                fc = Func3(c);
                error = Math.abs((c-c0)/c);
            
                System.out.printf("%d  %.5f\t%.5f\t\t%.5f\t\t%.5f   \t%.5f  \t%.5f",i,a,b,c,fa,fb,fc);
                System.out.println();
                a = b;
                b = c;
                i++;
            }
                System.out.printf("Akar persamaannya adalah %.5f",c);
                System.out.println();
        }
    }
}

public class Perhitungan
{
    /**
    * method main tempat menjalankan kode
    * @param args 
    */
    public static void main(String[] args) 
    {
        char ulang; // varibel ulang untuk menampung nilai char ketika ingin mengulang program
        int soal; // variabel soal unutk menampung nilai integer keitak ingin memilih soal
        
        Secant sc1 = new Secant(); // membuat objek sc1 dari class Secant
        
        Scanner scanner = new Scanner(System.in); // membuat object scanner untuk dapat memakai input-input untuk inputan
            
            do
            {   
                System.out.println("Program mencari akar persamaan Non-linear Mode Secant");
                System.out.println("Soal: ");
                System.out.println("1. Diberikan fungsi f(x) yaitu x*exp(-x)+sin(2*x) dengan nilai x=[1, 2.4], nilai iterasi adalah 10 dan nilai toleransi error adalah 0.002.");
                System.out.println("");
                System.out.println("2. Diberikan fungsi f(x) yaitu cos(x+1)+exp(-x+2) dengan nilai x=[1,3], nilai iterasi adalah 10 dan nilai toleransi error adalah 0.001.");
                System.out.println("");
                System.out.println("3. Diberikan fungsi f(x) yaitu cos(x)-sin(x) dengan nilai x=[0,2], nilai iterasi adalah 10 dan nilai toleransi error adalah 0.001.");
                System.out.println("");
                System.out.print("Silahkan Pilih nomor soal yang akan dicari: ");
                    soal = scanner.nextInt(); // nilai dari soal diinputkan melalui keyboard
                    System.out.println("");
                
                if(soal == 1) // kondisi jika memilih soal 1
                {
                    sc1.alur(1, 2.4, 0.002); // nilai parameter sesuai dengan soal 
                }
                else if(soal == 2) // kondisi jika memilih soal 2
                {
                    sc1.alur(1, 3, 0.001); // nilai parameter sesuai dengan soal
                }
                
                else if(soal == 3) // kondisi jika memilih soal 3
                {
                    sc1.alur(1, 2, 0.001); // nilai parameter sesuai dengan soal
                }else{
                    break; // program akan berhenti jika pilihan yang dimasukkan salah
                }
                System.out.print("Ingin lihat hasil soal lainnya(Y/n): ");
                ulang = scanner.next().charAt(0); // charAt(0) digunakan agar yang di input bertype char dan next dapat digunakan
                System.out.println("");
            }
            while(ulang == 'y' || ulang == 'Y');
        
        System.out.println("Terimakasih sudah menggunakan program ini!!");
        scanner.close(); // scanner di tutup agar tidak ada peringatan
    }
}
