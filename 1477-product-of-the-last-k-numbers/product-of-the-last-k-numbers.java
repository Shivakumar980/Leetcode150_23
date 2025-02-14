import java.util.Stack;

class ProductOfNumbers {
    Stack<Integer> product;

    public ProductOfNumbers() {
        product = new Stack<>();
    }

    public void add(int num) {
        if (num == 0) {
            product.clear(); // Reset if zero is added
        } else if (product.isEmpty()) {
            product.push(num);
        } else {
            product.push(product.peek() * num);
        }
    }

    public int getProduct(int k) {
        if (k > product.size()) {
            return 0; // If there aren't enough elements, return 0
        }
        if (k == product.size()) {
            return product.peek();
        }
        return product.peek() / product.get(product.size() - k - 1);
    }

}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */