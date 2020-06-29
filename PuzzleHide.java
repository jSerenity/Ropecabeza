public class PuzzleHide {
    private int spyIndexX;
    private int spyIndexY;
    PuzzleHide()
    {
        spyIndexX=3;
        spyIndexY=3;
    }

    public void SetX(int x){
        spyIndexX= x;
    }
    public void SetY(int y){
        spyIndexY= y;
    }
    public int GetX(){
        return spyIndexX;
    }
    public int GetY(){
        return spyIndexY;
    }
}