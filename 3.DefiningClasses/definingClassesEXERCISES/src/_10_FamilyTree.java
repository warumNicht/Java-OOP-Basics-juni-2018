import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _10_FamilyTree {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String wantedPerson=reader.readLine();

        List<PersonFamily> persons=new ArrayList<>();

        String input=reader.readLine();

        while ("End".equals(input)==false){

            if(input.contains("-")){
                String[] tokens=input.split("\\s-\\s");
                String parent=tokens[0];
                String kind=tokens[1];

                List<PersonFamily> curParent=persons.stream()
                        .filter(x->x.birthay.equals(parent)||x.name.equals(parent)).collect(Collectors.toList());

                if(curParent.isEmpty()){
                    PersonFamily curNewParent=new PersonFamily();
                    if(Character.isDigit(parent.charAt(0))){
                        curNewParent.setBirthay(parent);
                    }else {
                        curNewParent.setName(parent);
                    }
                    curNewParent.children.add(kind);
                    persons.add(curNewParent);
                }else if(curParent.size()==1){
                    PersonFamily curNewParent=curParent.get(0);
                    curNewParent.children.add(kind);
                }else {
                    PersonFamily curFirstParent=curParent.get(0);
                    PersonFamily curSecParent=curParent.get(1);
                    if(curFirstParent.name.equals("")){
                        curFirstParent.setName(curSecParent.name);
                    }else {
                        curFirstParent.setBirthay(curSecParent.birthay);
                    }
                    curFirstParent.parents.addAll(curSecParent.parents);
                    curFirstParent.children.addAll(curSecParent.children);
                    persons.remove(curSecParent);
                }

                List<PersonFamily> curKind=persons.stream()
                        .filter(x->x.birthay.equals(kind)||x.name.equals(kind)).collect(Collectors.toList());

                if(curKind.isEmpty()){
                    PersonFamily curNewKind=new PersonFamily();
                    if(Character.isDigit(kind.charAt(0))){
                        curNewKind.setBirthay(kind);
                    }else {
                        curNewKind.setName(kind);
                    }
                    curNewKind.parents.add(parent);
                    persons.add(curNewKind);
                }else if(curKind.size()==1){
                    PersonFamily curNewKind=curKind.get(0);
                    curNewKind.parents.add(parent);
                }else{
                    PersonFamily curFirstKind=curKind.get(0);
                    PersonFamily curSecKind=curKind.get(1);
                    if(curFirstKind.name.equals("")){
                        curFirstKind.setName(curSecKind.name);
                    }else {
                        curFirstKind.setBirthay(curSecKind.birthay);
                    }
                    curFirstKind.parents.addAll(curSecKind.parents);
                    curFirstKind.children.addAll(curSecKind.children);
                    persons.remove(curSecKind);
                }

            }else {
                String[] tokens=input.split("\\s+");
                String name=tokens[0]+" "+tokens[1];
                String date=tokens[2];

                List<PersonFamily> toChange=persons.stream()
                        .filter(x->x.birthay.equals(date)||x.name.equals(name))
                        .collect(Collectors.toList());

                if(toChange.isEmpty()){
                    PersonFamily curMember=new PersonFamily();
                    curMember.setName(name);
                    curMember.setBirthay(date);
                    persons.add(curMember);
                }else if(toChange.size()==1){
                    toChange.get(0).setName(name);
                    toChange.get(0).setBirthay(date);
                }else {
                    PersonFamily first=toChange.get(0);
                    PersonFamily sec=toChange.get(1);
                    persons.remove(sec);

                    if(first.name.equals("")){
                        first.setName(sec.name);
                    }else {
                        first.setBirthay(sec.birthay);
                    }

                    first.parents.addAll(sec.parents);
                    first.children.addAll(sec.children);
                }
            }
            input=reader.readLine();
        }

        List<PersonFamily> fin=persons.stream()
                .filter(x->x.name.equals(wantedPerson)||x.birthay.equals(wantedPerson))
                .collect(Collectors.toList());

        PersonFamily result=fin.get(0);
        System.out.printf("%s %s%n",result.name,result.birthay);
        System.out.println("Parents:");

        result.parents.stream()
                .forEach(p->{
                    persons.stream()
                            .filter(y->y.name.equals(p)||y.birthay.equals(p))
                            .limit(1)
                            .forEach(f-> System.out.printf("%s %s%n",f.name,f.birthay));
                });
        System.out.println("Children:");

        result.children.stream()
                .forEach(k->{
                    persons.stream()
                            .filter(p->p.name.equals(k)||p.birthay.equals(k))
                            .limit(1)
                            .forEach(f-> System.out.printf("%s %s%n",f.name,f.birthay));
                });

    }

}
class PersonFamily{
    String name;
    String birthay;
    List<String> parents;
    List<String> children;

    public PersonFamily() {
        this.name="";
        this.birthay="";
        this.parents=new ArrayList<>();
        this.children=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthay() {
        return birthay;
    }

    public void setBirthay(String birthay) {
        this.birthay = birthay;
    }
}
