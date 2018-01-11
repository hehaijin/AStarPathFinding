package AStarPathFinding;

import java.util.ArrayList;

// I include this file, because this is the first time I feel the power of algorithm in real projects.
// We are asked to generate a graph connecting all workds in an dictionary, each word being a node, 
// and each edge being one modification away from another work. And we want it as fast as possible.
// Instead of optimizing the code on decide if each pair are neighors or not,
// I first generate all posible neighbors and loot it up in the dictionary.
// this reduced the complexity from O(N^2) to O(N)
// as a result, my program finishes in 6 seconds, while the target running time is 1 minite.
// The graph class uses this StringNeighbor class to generate the graph. 



/**
 * This class has a static method that generate all possible neighbors for a
 * given string.
 * 
 * @author Haijin He
 *
 */

public class StringNeighbor
{

  /**
   * This method is used to generate all possible neighbor strings with same and
   * less than 1 length.
   * 
   * @param s
   *          the target string
   * @return a string vector containing all possible neighbors same length or 1
   *         letter shorter.
   */

  public static String[] generate(String s)
  {
    ArrayList<String> list = new ArrayList<>();
    for (int j = 0; j < 26; j++)
      for (int i = 0; i < s.length(); i++)
      {
        if ('a' + j != s.charAt(i)) // to eliminate s itself
          list.add(s.substring(0, i) + (char) ('a' + j) + s.substring(i + 1));
      }
    for (int i = 0; i < s.length(); i++)
      list.add(s.substring(0, i) + s.substring(i + 1));
    // output to a string array.
    String str[] = new String[list.size()];
    int index = 0;
    for (String s1 : list)
    {
      str[index] = s1;
      index++;
    }
    return str;
  }

  /**
   * Main method. Used for testing.
   */

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    String[] str = generate("a");
    for (String s : str)
      System.out.println(s);
    System.out.println(str.length);
  }

}
