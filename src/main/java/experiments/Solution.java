package experiments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }
    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Heading> headings = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            headings.add(parse(line));
        }
        Node outline = toOutline(headings);
        String html = toHtml(outline);
        System.out.println(html);
    }

    private static Node toOutline(List<Heading> headings) {
        // Implement this function. Sample code below builds an
        // outline of only the first heading.
        int lowestPriority = 0;
        Node root = new Node(new Heading(0, ""));
        Node currentNode = root;
        Node previousNode = null;
        for (int i = 0; i < headings.size(); i++) {
            Heading h = headings.get(i);
            if (h.weight > lowestPriority) {
                Node newNode = new Node(h);
                currentNode.children.add(newNode);
                previousNode = currentNode;
                currentNode = newNode;
                lowestPriority = h.weight;
            } else {

            }
        }
        return root;
    }

    /** Parses a line of input.
     This implementation is correct for all predefined test cases. */
    private static Heading parse(String record) {
        String[] parts = record.split(" ", 2);
        int weight = Integer.parseInt(parts[0].substring(1));
        Heading heading = new Heading(weight, parts[1].trim());
        return heading;
    }

    /** Converts a node to HTML.
     This implementation is correct for all predefined test cases. */
    private static String toHtml(Node node) {
        StringBuilder buf = new StringBuilder();
        if (!node.heading.text.isEmpty()) {
            buf.append(node.heading.text);
            buf.append("\n");
        }
        Iterator<Node> iter = node.children.iterator();
        if (iter.hasNext()) {
            buf.append("<ol>");

            while (iter.hasNext()) {
                Node child = iter.next();
                buf.append("<li>");
                buf.append(toHtml(child));
                buf.append("</li>");
                if (iter.hasNext()) {
                    buf.append("\n");
                }
            }
            buf.append("</ol>");
        }
        return buf.toString();
    }

}
