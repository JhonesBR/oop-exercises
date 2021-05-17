/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class Tab {

    int N = 1000;
    int[][] V = new int[N][N];

    public Tab() {
    }

    public int getSize() {
        return N;
    }

    public void setSize(int n) {
        N = n;
    }

    public int[][] getV() {
        return V;
    }

    public void setV(int n, int x, int y) {
        V[x][y] = n;
    }

    public int getVMember(int x, int y) {
        return V[x][y];
    }
}
