class Solution {
    public String reverseWords(String s) {
        ArrayList<String> sl = new ArrayList<>();
        int front = s.length() - 1; 
        int rear = s.length() - 1;

        // Traverse the string from the end
        while (front >= 0) {
            char f = s.charAt(front);
            char r = s.charAt(rear);
            
            // Skip spaces at the end or between words
            if (f == ' ' && r == ' ') {
                front--;
                rear--;
            }
            // If we encounter a space and we are at the end of a word
            else if (f == ' ' && r != ' ') {
                // Add the word between front+1 and rear
                sl.add(s.substring(front + 1, rear + 1));
                rear = front; // Move rear to current front position
            }
            // If still part of a word
            else {
                front--;
            }
        }

        // Add the last word if there is any (corner case when first word has no leading space)
        if (rear >= 0 && s.charAt(rear) != ' ') {
            sl.add(s.substring(0, rear + 1));
        }

        // Join the words in reverse order to form the result
        return String.join(" ", sl);
    }
    }