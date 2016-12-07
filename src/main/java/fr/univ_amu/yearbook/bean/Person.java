package fr.univ_amu.yearbook.bean;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

/**
 * <b>Person</b> est la classe qui permet de créer une personne
 * de l'annuaire.
 * 
 * Une personne de l'annuaire est caractérisée par :
 * <ul>
 * <li>Un identifiant unique.</li>
 * <li>Un nom.</li>
 * <li>Un prénom.</li>
 * <li>Un email unique.</li>
 * <li>Un site web unique.</li>
 * <li>Une date de naissance.</li>
 * <li>Un mot de passe.</li>
 * <li>L'identifiant d'un groupe.</li>
 * </ul>
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * 
 * @version 1.2
 *
 */
public class Person {
	
	/**
	 * L'identifiant d'une personne. Cet id n'est pas modifiable.
	 * 
	 * @see #getId()
	 * @see #setId(Long)
	 */
	private Long id;
	
	/**
	 * Le nom d'une personne
	 * 
	 * @see #getLastName()
	 * @see #setLastName(String)
	 */
	@NotNull
	@Min(value=2, message="Le nom doit contenir au moins 2 caractères")
    @Max(value=20, message="Le nom doit contenir au plus 20 caractères")
	@Pattern(regexp="[A-Z][A-Za-Z-]*", message="Le nom doit débuter par une majuscule et contenir que des lettres ou -")
	private String lastName;
	
	/**
	 * Le prénom d'une personne.
	 * 
	 * @see #getFirstName()
	 * @see #setFirstName(String)
	 */
	@NotNull
	@Min(value=2, message="Le prénom doit contenir au moins 2 caractères")
    @Max(value=20, message="Le prénom doit contenir au plus 20 caractères")
	@Pattern(regexp="[A-Z][A-Za-Z-]*", message="Le prénom doit débuter par une majuscule et contenir que des lettres ou -")
	private String firstName;
	
	/**
	 * L'email d'une personne.
	 * 
	 * @see #getEmail()
	 * @see #setEmail(String)
	 */
	@NotNull
	@Min(value=8, message="L'email doit contenir au moins 8 caractères")
    @Max(value=20, message="L'email doit contenir au plus 20 caractères")
	@Pattern(regexp="^[a-z][\\.\\w]*@[a-z]+[a-z\\.-]+[a-z]+\\.[a-z]{2,4}$", message="Email valide : test@etu.univ-amu.fr")
	private String email;
	
	/**
	 * Le site web d'une personne
	 * 
	 * @see #getHomePage()
	 * @see #setHomePage(String)
	 */
	@Null
	@Min(value=8, message="La page web doit contenir au moins 8 caractères")
    @Max(value=20, message="La page web doit contenir au plus 20 caractères")
	@Pattern(regexp="[w]{3}\\.[a-z\\._-]+\\.[a-z\\.~/_-]{2,}$", message="Exemple de page web valide : www.etu.univ-amu.fr")
	private String homePage;
	
	/**
	 * La date de naissance d'une personne
	 * 
	 * @see #getBirthDate()
	 * @see #setBirthDate(Date)
	 */
	private Date birthDate;
	
	/**
	 * Le mot de passe d'une personne
	 * 
	 * @see #getPwd()
	 * @see #setPwd(String)
	 */
	private String pwd;
	
	/**
	 * L'identifiant du groupe auquel appartient la personne.
	 * 
	 * @see #getIdG()
	 * @see #setIdG(Long idG)
	 */
	private Long idG;
	
	/**
	 * Constructeur par défaut de la classe Person.
	 */
	public Person() {
		super();
	}
	
	/**
	 * Retourne l'id de la personne.
	 * Cet attribut ne peut être modifié.
	 * 
	 * @return 
	 * 		L'identifiant.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Met à jour l'id de la personne.
	 * 
	 * @param id Le nouveau id.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Retourne le prénom de la personne.
	 * 
	 * @return Le prénom.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Met à jour le prénom de la personne.
	 * 
	 * @param lastName Le nouveau prénom.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retourne le nom de la personne.
	 * 
	 * @return Le nom.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Met à jour le nom de la personne.
	 * 
	 * @param firstName Le nouveau nom.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Retourne l'email de la personne.
	 * 
	 * @return L'email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Met à jour l'email de la personne.
	 * Cet email est unique.
	 * 
	 * @param email Le nouveau mail.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retourne le site web de le personne.
	 * 
	 * @return Le site web.
	 */
	public String getHomePage() {
		return homePage;
	}

	/**
	 * Met à jour le site web de la personne.
	 * Cet site web est unique.
	 * 
	 * @param homePage Le nouveau site web.
	 */
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	/**
	 * Retourne la date de naissance de la personne.
	 * 
	 * @return La date de naissance.
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Met à jour la date de naissance de la personne.
	 * 
	 * @param dateOfBirth La nouvelle date de naissance.
	 */
	public void setBirthDate(Date dateOfBirth) {
		this.birthDate = dateOfBirth;
	}

	/**
	 * Retourne le mot de passe de la personne.
	 * 
	 * @return Le mot de passe. 
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Met à jour le mot de passe de la personne.
	 * 
	 * @param pwd Le nouveau mot de passe.
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Retourne le numéro du auquel appartient la personne.
	 * 
	 * @return Le groupe de la personne.
	 */
	public Long getIdG() {
		return idG;
	}

	/**
	 * Met à jour du groupe auquel appartient la personne.
	 * 
	 * @param idG Le nouveau groupe.
	 */
	public void setIdG(Long idG) {
		this.idG = idG;
	}
}