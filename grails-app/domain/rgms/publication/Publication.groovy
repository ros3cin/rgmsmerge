package rgms.publication

import rgms.member.Member

abstract class Publication {

    String title
    Date publicationDate
    String file
    ResearchLine researchLine

    static belongsTo = Member
    static hasMany = [members: Member]

    static constraints = {
        title nullable: false, blank: false
        publicationDate nullable: false
        file maxSize: 100000
        researchLine nullable: true, blank: true
    }

    //#if($Bibtex)
    abstract String generateBib()
    //#end

    public String toString() {
        return title
    }

//	static Set getPublicationsByMembershipList(membershipList){
//		def set = [] as Set
//		for(membership in membershipList){
//			set.addAll(Publication.getPublicationsByMembership(membership))
//		}
//                return set
//	}

//	static Set getPublicationsByMembership(membership){
//		def publications = membership?.member.publications
//		def query = !membership.dateLeft ?
//					{ it.publicationDate?.compareTo(membership.dateJoined) > 0 }:
//					{ it.publicationDate?.compareTo(membership.dateJoined) > 0  &&
//						it.publicationDate?.compareTo(membership.dateLeft) < 0}
//                def p = publications?.findAll(query)
//		return p
//	}

//	public String retPrimeiroAutor(){
//		String[] quebraString = this.author.tokenize(",")
//		String nomeAutor = quebraString[0]
//		String[] quebraNovo = nomeAutor.split()
//		String ultimoNome = quebraNovo[quebraNovo.length-1]
//		return ultimoNome
//	}

//	public String retListaAutor(){
//		
//		String[] quebraString = this.author.tokenize(",")
//		String lista =""
//		//quebraString.each { if(quebraString.length()); lista}
//		int valor=0
//		for(i in quebraString){
//			if(valor!=(quebraString.length-1)){
//				lista = lista+i+" and "
//				valor++
//			}else{
//				lista = lista+i
//			}
//		}
//		
//		return lista;
//	}
}
