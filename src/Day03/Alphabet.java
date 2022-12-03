package Day03;

public enum Alphabet {
    a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

    public static int getNum(String targ) {
        return valueOf(targ).ordinal() + 1;
    }

    public static int getNum(char targ) {
        return valueOf(String.valueOf(targ)).ordinal() + 1;
    }
}