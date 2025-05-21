package namedEntity.heuristic;

import java.util.List;
import namedEntity.*;
import namedEntity.person.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

public class QuickHeuristic extends Heuristic{
	
	private static List<String> keyWords = List.of(
		    "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you",
		    "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she",
		    "her", "hers", "herself", "it", "its", "itself", "they", "them", "your",
		    "their", "theirs", "themselves", "what", "which", "who", "whom",
		    "this", "that", "these", "those", "am", "is", "are", "was", "were",
		    "be", "been", "being", "have", "has", "had", "having", "do", "does",
		    "did", "doing", "a", "an", "the", "and", "but", "if", "or",
		    "because", "as", "until", "while", "of", "at", "by", "for", "with",
		    "about", "against", "between", "into", "through", "during", "before",
		    "after", "above", "below", "to", "from", "up", "down", "in", "out",
		    "off", "over", "under", "again", "further", "then", "once", "here",
		    "there", "when", "where", "why", "how", "all", "any", "both", "each",
		    "few", "more", "most", "other", "some", "such", "no", "nor", "not",
		    "only", "own", "same", "so", "than", "too", "very", "s", "t", "can",
		    "will", "just", "don", "should", "now", "on",
		    // Contractions without '
		    "im", "ive", "id", "Youre", "youd", "youve",
		    "hes", "hed", "shes", "shed", "itd", "were", "wed", "weve",
		    "theyre", "theyd", "theyve",
		    "shouldnt", "couldnt", "musnt", "cant", "wont",
		    // Common uppercase words
		    "hi", "hello"
			);
	
	
	public boolean isEntity(String word) {
		return word.length() > 1 && word.substring(0, 1).compareTo(word.substring(0, 1).toUpperCase()) == 0 && !keyWords.contains(word.toLowerCase());
	}
	
	public List<NamedEntity> classify (ArrayList<String> candidates) {
		List<NamedEntity> classifiedEnts = new ArrayList<>();
		List<String> entities = candidates.stream().filter(s -> this.isEntity(s)).collect(Collectors.toList());
		for (int i = 0; i < entities.size(); i++) {
			String category = super.getCategory(entities.get(i));
			String entName = entities.get(i);
			if(category!=null && category.equals("Company")) {
				int index = IntStream.range(0, classifiedEnts.size()).filter(j -> classifiedEnts.get(j).getName().equals(entName)).findFirst().orElse(-1);

				if(index != -1){
					classifiedEnts.get(index).incFrequency();
				} else {
					Organization org = new Organization(entities.get(i), 1);
					org.setCanonicForm(entities.get(i));
					classifiedEnts.add(org);
				}
			} else if (category!=null && category.equals("Person")) {

				int index = IntStream.range(0, classifiedEnts.size()).filter(j -> classifiedEnts.get(j).getName().equals(entName)).findFirst().orElse(-1);

				if(index != -1){
					classifiedEnts.get(index).incFrequency();
				} else {
					Person per = new Person(entities.get(i), 1);
					per.setLastName(entities.get(i), Optional.empty());
					classifiedEnts.add(per);
				}
			} else if(category!=null && category.equals("Country")) {

				int index = IntStream.range(0, classifiedEnts.size()).filter(j -> classifiedEnts.get(j).getName().equals(entName)).findFirst().orElse(-1);

				if(index != -1){
					classifiedEnts.get(index).incFrequency();
				} else {
					Other oth = new Other(entities.get(i), 1, "Pais");
					classifiedEnts.add(oth);
				}
			} else {

				int index = IntStream.range(0, classifiedEnts.size()).filter(j -> classifiedEnts.get(j).getName().equals(entName)).findFirst().orElse(-1);

				if(index != -1){
					System.out.println(index);
					classifiedEnts.get(index).incFrequency();
				} else {
					Other oth = new Other(entities.get(i), 1, "???");
					classifiedEnts.add(oth);
				}
			}
		}

		return classifiedEnts;
	}

	public static void main(String[] args) {
//		QuickHeuristic qh = new QuickHeuristic();
	}

	
	

}

