import tourism.Site;

class Program {

    public static void main(String[] args) throws Exception {
        try(Site mysite = Site.load("CitiZoo")){
            if(args.length > 0){
                var visitor = mysite.getVisitor(args[0]);
                visitor.visit();
                System.out.printf("Welcome %s, your ticket number is %d%n", visitor.getName(), visitor.getTicket());
            }else{
                for(var visitor : mysite.getVisitors()){
                    System.out.printf("%s\t%d\t%s%n", visitor.getName(), visitor.getVisitCount(), visitor.getLastVisit());
                }
            }
        }
    }
}
