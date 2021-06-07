package FirstCICDServerPackage;

public class TestKlasse1 {
    String mName = "";
    int mJahrgang = 0;


    TestKlasse1(String pName, int pJahrgang){
        mName = pName;
        mJahrgang = pJahrgang;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmJahrgang() {
        return mJahrgang;
    }

    public void setmJahrgang(int mJahrgang) {
        this.mJahrgang = mJahrgang;
    }
}
