
public class Work {

  public static void main(String[] args) {
    SimilarityMeasure sim=new SentenceVectorsBasedSimilarity();
    double sdf = sim.getSimilarity("sankarmuthu ganesh", "sankarganesh muthu");
    System.out.println(sdf);
    System.out.println("sankar");
  }

}
