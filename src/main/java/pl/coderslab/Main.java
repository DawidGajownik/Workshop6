package pl.coderslab;

public class Main {
    public static void main(String[] args) {
        MockBookService mockBookService = new MockBookService();
//        System.out.println(mockBookService.get(8L).get().getTitle());
//        System.out.println(mockBookService.getBooks().stream()
//                .filter(s -> s.getId().equals(8L))
//                .findFirst());
        //mockBookService.add(new Book("isbn","tytu","autor","publisher","type"));
        //mockBookService.add(new Book("isbn","tytu","autor","publisher","type"));
        //mockBookService.add(new Book("isbn","tytu","autor","publisher","type"));
        //mockBookService.add(new Book("isbn","tytu","autor","publisher","type"));
        //mockBookService.add(new Book("isbn","tytu","autor","publisher","type"));
        System.out.println(mockBookService.getBooks().get(mockBookService.getBooks().size()-1).getId());
    }
}
