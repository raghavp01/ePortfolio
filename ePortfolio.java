package ePortfolio;

import java.util.*;

/**
 * Class that contains the arraylists
 */
public class ePortfolio 
{

    private ArrayList<Investment> investments;
    private Map<String, ArrayList<Integer>> nameKeywordindex;

    /**
     * 
     * @return returns the investments
     */
    public ArrayList<Investment> returnInvestments () 
    {
        return investments;
    }

    /**
     * 
     * @param investment takes investment
     * @return returns true or false
     */
    public boolean addInvestment ( Investment investment ) 
    {
        if ( investments == null ) 
        {
            investments = new ArrayList<>();
        }
        String[] stringArray = investment.returnName ().split ( " " );
        for ( String tempString : stringArray ) 
        {
            addKeyword(tempString);
        }
       return investments.add(investment);
    }

    private void addKeyword ( String word ) 
    {
        if ( nameKeywordindex == null ) 
        {
            nameKeywordindex = new HashMap<> ();
        }
        if ( nameKeywordindex.containsKey ( word ) ) 
        {
            ArrayList<Integer> val = nameKeywordindex.get ( word );
            val.add ( investments.size ( ) - 1 );
            nameKeywordindex.replace ( word, val );
        } 
        else 
        {
            ArrayList<Integer> val = new ArrayList<> ();
            val.add ( investments.size () - 1 );
            nameKeywordindex.put ( word, val );
        }
    }

    /**
     * 
     * @param tempSymbol symbol
     * @return returns null or investment
     */
    public Investment checkThroughSymbol ( String tempSymbol ) 
    {
        if ( investments == null )
        {
            return null;
        }
        if ( investments != null ) 
        {
            for ( Investment investment : investments ) 
            {
                if ( investment.returnSymbol ( ) .equalsIgnoreCase ( tempSymbol ) ) 
                {
                    return investment;
                }
            }
        }  
        return null;      
    }

    /**
     * 
     * @param tempString takes input as a string
     * @return returns the investments
     */
    public ArrayList<Investment> checkThroughKeyword(String tempString) 
    {
        String[] arrayOfWords = tempString.split(" ");
        ArrayList<Investment> listOfInvestments = new ArrayList<>();
        if (investments != null) 
        {
            for (Investment investment : investments) 
            {
                String[] investmentarrayOfWords = investment.returnName().split(" ");
                int all = 1;
                for (String keyword : arrayOfWords) 
                {
                    int one = 0;
                    for (String stockKeyword : investmentarrayOfWords) 
                    {
                        if (stockKeyword.equalsIgnoreCase(keyword)) 
                        {
                            one = 1;
                            break;
                        }
                    }
                    all = one;
                }
                if (all == 1) 
                {
                    listOfInvestments.add(investment);
                }
            }
        }
        return listOfInvestments;
    }

    /**
     * 
     * @param symbol takes input as symbol
     * @param price takes input as price
     * @return returns the investments
     */
    ArrayList<Investment> combinedSearch(String symbol, String price) 
    {
        ArrayList<Investment> investments = new ArrayList<>();
        if (price.charAt(0) == '-') 
        {
            double val = Double.parseDouble(price.substring(1));
            if (returnInvestments() != null) 
            {
                Investment investment = checkThroughSymbol(symbol);
                if (investment != null) 
                {
                    if (investment.returnPrice() <= val) 
                    {
                        investments.add(investment);
                    }
                }
            }
        } 
        else if (price.charAt(price.length() - 1) == '-') 
        {
            double val = Double.parseDouble(price.substring(0, price.length() - 1));
            if (returnInvestments() != null) 
            {
                Investment investment = checkThroughSymbol(symbol);
                if (investment != null) 
                {
                    if (investment.returnPrice() >= val) 
                    {
                        investments.add(investment);
                    }
                }
            }
        } 
        else 
        {
            String[] splitPrice = price.split("-");
            if (returnInvestments() != null) 
            {
                if (splitPrice.length == 2) 
                {
                    Investment investment = checkThroughSymbol(symbol);
                    if (investment != null) 
                    {
                        double lowerVal = Double.parseDouble(splitPrice[0]);
                        double upperval = Double.parseDouble(splitPrice[1]);
                        if (investment.returnPrice() >= lowerVal && investment.returnPrice() <= upperval) 
                        {
                            investments.add(investment);
                        }
                    }
                } 
                else {
                    Investment investment = checkThroughSymbol(symbol);

                    if (investment != null) 
                    {
                        double val = Double.parseDouble(splitPrice[0]);
                        if (investment.returnPrice() == val) 
                        {
                            investments.add(investment);
                        }
                    }
                }
            }
        }
        return investments;
    }
}
