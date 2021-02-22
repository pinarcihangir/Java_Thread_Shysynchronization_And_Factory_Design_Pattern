
package nesnefinal;


public class MultiplyWorker implements Runnable{

    private final Buffer sharedBuffer;
    private int[] satir;
    private int[][] ikinciMatris;
    private int satirIndex;
    private int sutunIndex;
    private int rowIndex;
    public MultiplyWorker(int[] satir, int[][] matris,int rowIndex, Buffer buffer){
        sharedBuffer = buffer;
        this.satir = satir;
        ikinciMatris = matris;
        satirIndex=0;
        sutunIndex=0;
        this.rowIndex = rowIndex;

    }
    @Override
    public void run() {
        //matris çarpımında sonuc matrisi birinci matrisin satir sayisi X ikinci matrisin sütun sayısı boyutlarında olur. Bu yüzden
        for(int i=0;i<ikinciMatris[0].length;i++){ //0,1 
            int toplam=0;
            for(int k=0;k<ikinciMatris.length;k++){//0,1,2 ikinci matrisin satır sayısı kadar dönecek
                int carpim = satir[k]*ikinciMatris[k][i];
                toplam+=carpim;
            }
            sharedBuffer.Put(rowIndex,i , toplam);
        }
    }
    
}
