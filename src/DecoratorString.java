public abstract class DecoratorString implements TransformationStrategy{
private TransformationStrategy newtransformation;

    public DecoratorString(TransformationStrategy transformationstrategy){
       this.newtransformation=transformationstrategy;
    }



    @Override
    public String transform(String str) {
        return  newtransformation.transform(str);

    }

//    @Override
//    public String transform(String str) {
//        return "new StringBuilder(str).reverse().toString()";
//    }



}
