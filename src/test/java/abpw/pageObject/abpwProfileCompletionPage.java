package abpw.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abpwProfileCompletionPage 
{
	WebDriver ldriver;
	public abpwProfileCompletionPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements((WebDriver) rdriver, this);
	}	
//	==================== Start Edit Profile =========================================
	@FindBy(xpath="(//*[contains(text(),'Edit Profile')])[2]")
	@CacheLookup
	WebElement linkEditProfile;
	
	public void clickOnEditProfileLink()
	{
		linkEditProfile.click();
	}
	
//--------------- about-me -------------------------------------------------
	@FindBy(xpath="//a[@class='edit-about-me']")
	@CacheLookup
	WebElement icon_AboutMe;
	
	@FindBy(name="quetionsAnswer1")
	@CacheLookup
	WebElement txt_quetionsAnswer1;
	
	@FindBy(name="quetionsAnswer3")
	@CacheLookup
	WebElement txt_quetionsAnswer3;
	
	@FindBy(xpath="(//*[@class='btn btn-primary saveto_profile'])[2]")
	@CacheLookup
	WebElement btn_SaveAboutMe;
	
	public void click_About_Me_Icon() throws InterruptedException
	{
		icon_AboutMe.click();
		Thread.sleep(3000);
	}
	
	public void set_About_Me_Que1(String Que1) 
	{
		txt_quetionsAnswer1.clear();
		txt_quetionsAnswer1.sendKeys(Que1);
	}
	public void set_About_Me_Que3(String Que3) 
	{
		txt_quetionsAnswer3.clear();
		txt_quetionsAnswer3.sendKeys(Que3);
	}
	public void save_About_Me()
	{
		btn_SaveAboutMe.click();
	}
//--------------- Personal Information ----------------------------------------
	@FindBy(xpath="//a[@class='edit-personal-information']")
	@CacheLookup
	WebElement icon_Personal_Information;
	
	@FindBy(xpath="(//*[contains(text(),'Kids')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Kids;
	
	@FindBy(xpath="(//*[contains(text(),'Kids')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Kids;
	
	@FindBy(xpath="(//*[contains(text(),'Manglik')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Manglik;
	
	@FindBy(xpath="(//*[contains(text(),'Manglik')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Manglik;
	
	@FindBy(xpath="(//*[@class='btn btn-primary saveto_profile'])[3]")
	@CacheLookup
	WebElement btn_Personal_Information;
	
	public void click_Personal_Information_Icon() throws InterruptedException
	{
		icon_Personal_Information.click();
		Thread.sleep(3000);
	}
	
	public void set_Kids(String Kids) throws InterruptedException 
	{
		field_Kids.click();
		dd_Kids.sendKeys(Kids);
		dd_Kids.sendKeys(Keys.ENTER);
	}
	public void set_Manglik(String Manglik) throws InterruptedException 
	{
		dd_Manglik.sendKeys(Manglik);
		dd_Manglik.sendKeys(Keys.ENTER);
	}

	public void save_Personal_Information()
	{
		btn_Personal_Information.click();
	}
	
//--------------- Professional background ----------------------------------------
	@FindBy(xpath="//a[@class='edit-professional-background']")
	@CacheLookup
	WebElement icon_Professionalbackground;
	
	@FindBy(xpath="(//*[contains(text(),'Occupation')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Occupation;
	
	@FindBy(xpath="(//*[contains(text(),'Occupation')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Occupation;
	
	@FindBy(xpath="(//*[contains(text(),'Designation')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Designation;
	
	@FindBy(xpath="(//*[contains(text(),'Designation')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Designation;
	
	@FindBy(name="companyName")
	@CacheLookup
	WebElement txt_companyName;
	
	@FindBy(xpath="(//*[contains(text(),'Industry')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Industry;
	
	@FindBy(xpath="(//*[contains(text(),'Industry')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Industry;
	
	@FindBy(xpath="(//*[contains(text(),'Income')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Income;
	
	@FindBy(xpath="(//*[contains(text(),'Income')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Income;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary'])[1]")
	@CacheLookup
	WebElement btn_SaveProfessionalBackground;
	
	public void ClickOn_Professiona_background_Icon() throws InterruptedException
	{
		icon_Professionalbackground.click();
		Thread.sleep(3000);
	}
	public void setOccupation(String Occupation)
	{
		field_Occupation.click();
		dd_Occupation.sendKeys(Occupation);
		dd_Occupation.sendKeys(Keys.ENTER);
	}
	public void setDesignation(String Designation)
	{
		field_Designation.click();
		dd_Designation.sendKeys(Designation);
		dd_Designation.sendKeys(Keys.ENTER);
	}
	
	public void setCompanyName(String companyName)
	{
		txt_companyName.clear();
		txt_companyName.sendKeys(companyName);
	}
	public void setIndustry(String Industry)
	{
		field_Industry.click();
		dd_Industry.sendKeys(Industry);
		dd_Industry.sendKeys(Keys.ENTER);
	}
	public void setIncome(String Income)
	{
		field_Income.click();
		dd_Income.sendKeys(Income);
		dd_Income.sendKeys(Keys.ENTER);
	}
	public void save_ProfessionalBackground()
	{
		btn_SaveProfessionalBackground.click();
	}
//--------------- Educational background ----------------------------------------
	@FindBy(xpath="//a[@class='edit-educational-background']")
	@CacheLookup
	WebElement icon_educationalbackground;
	
	@FindBy(xpath="(//*[contains(text(),'Highest education')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_HighestEducation;
	
	@FindBy(xpath="(//*[contains(text(),'Highest education')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_HighestEducation;
	
	@FindBy(xpath="(//*[contains(text(),'Specialisation')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Specialisation;
	
	@FindBy(xpath="(//*[contains(text(),'Specialisation')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Specialisation;
	
	@FindBy(name="highestEduInstituteVal")
	@CacheLookup
	WebElement txt_highestEduInstituteVal;
	
	@FindBy(name="schoolName")
	@CacheLookup
	WebElement txt_schoolName;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary '])[1]")
	@CacheLookup
	WebElement btn_SaveEducationalBackground;
	
	public void ClickOn_educationalbackground_Icon() throws InterruptedException
	{
		icon_educationalbackground.click();
		Thread.sleep(2000);
	}
	public void setHighestEducation(String HighestEducation)
	{
		field_HighestEducation.click();
		dd_HighestEducation.sendKeys(HighestEducation);
		dd_HighestEducation.sendKeys(Keys.ENTER);
	}
	public void setSpecialisation(String Specialisation)
	{
		field_Specialisation.click();
		dd_Specialisation.sendKeys(Specialisation);
		dd_Specialisation.sendKeys(Keys.ENTER);
	}
	public void setHighestEduInstitute(String highestEduInstituteVal)
	{		
		txt_highestEduInstituteVal.clear();
		txt_highestEduInstituteVal.sendKeys(highestEduInstituteVal);		
	}
	public void setSchoolName(String schoolName)
	{		
		txt_schoolName.clear();
		txt_schoolName.sendKeys(schoolName);		
	}
	
	public void save_EducationalBackground()
	{
		btn_SaveEducationalBackground.click();
	}
//--------------- Physical Description ----------------------------------------	
	@FindBy(xpath="//a[@class='edit-physical-description']")
	@CacheLookup
	WebElement icon_physical_description;
	
	@FindBy(xpath="(//*[contains(text(),'Body type')])[1]//following::div[1]")
	@CacheLookup
	WebElement field_Body_type;
	
	@FindBy(xpath="(//*[contains(text(),'Body type')])[1]//following::input[1]")
	@CacheLookup
	WebElement dd_Body_type;
	
	@FindBy(xpath="(//*[contains(text(),'Height')])[3]//following::div[1]")
	@CacheLookup
	WebElement field_Height;
	
	@FindBy(xpath="(//*[contains(text(),'Height')])[3]//following::input[1]")
	@CacheLookup
	WebElement dd_Height;
	
	@FindBy(xpath="(//*[contains(text(),'Complexion')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Complexion;
	
	@FindBy(xpath="(//*[contains(text(),'Complexion')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Complexion;
	
	@FindBy(xpath="(//*[contains(text(),'Blood Group')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_BloodGroup;
	
	@FindBy(xpath="(//*[contains(text(),'Blood Group')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_BloodGroup;
	
	@FindBy(xpath="(//*[contains(text(),'Disabilities')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Disabilities;
	
	@FindBy(xpath="(//*[contains(text(),'Disabilities')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Disabilities;
	
	@FindBy(xpath="(//*[contains(text(),'Known Ailments')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_KnownAilments;
	
	@FindBy(xpath="(//*[contains(text(),'Known Ailments')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_KnownAilments;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary '])[2]")
	@CacheLookup
	WebElement btn_SavePhysicalDescription;
	
	public void ClickOn_PhysicalDescription_Icon()
	{
		icon_physical_description.click();
	}
	public void setBody_type(String Body_type)
	{
		field_Body_type.click();
		dd_Body_type.sendKeys(Body_type);
		dd_Body_type.sendKeys(Keys.ENTER);
	}
	
	public void setHeight(String Height)
	{
		field_Height.click();
		dd_Height.sendKeys(Height);
		dd_Height.sendKeys(Keys.ENTER);
	}
	
	public void setComplexion(String Complexion)
	{
		field_Complexion.click();
		dd_Complexion.sendKeys(Complexion);
		dd_Complexion.sendKeys(Keys.ENTER);
	}
	
	public void setBloodGroup(String BloodGroup)
	{
		field_BloodGroup.click();
		dd_BloodGroup.sendKeys(BloodGroup);
		dd_BloodGroup.sendKeys(Keys.ENTER);
	}
	
	public void setDisabilities(String Disabilities)
	{
		field_Disabilities.click();
		dd_Disabilities.sendKeys(Disabilities);
		dd_Disabilities.sendKeys(Keys.ENTER);
	}
	
	public void setKnownAilments(String KnownAilments)
	{
		field_KnownAilments.click();
		dd_KnownAilments.sendKeys(KnownAilments);
		dd_KnownAilments.sendKeys(Keys.ENTER);
	}
	
	public void save_PhysicalDescription()
	{
		btn_SavePhysicalDescription.click();
	}
	
	//--------------- Astrology Details ----------------------------------------	
	
	@FindBy(xpath="//a[@class='edit-astrology-details']")
	@CacheLookup
	WebElement icon_AstrologyDetails;
	
	@FindBy(xpath="(//*[contains(text(),'Place of birth')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_PlaceOfBirth;
	
	@FindBy(xpath="(//*[contains(text(),'Place of birth')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_PlaceOfBirth;
	
	@FindBy(xpath="((//*[contains(text(),'Time of birth')])[2]//following::div[1]//following::div[1])[1]")
	@CacheLookup
	WebElement field_TimeOfBirth;
	
	@FindBy(xpath="((//*[contains(text(),'Time of birth')])[2]//following::div[1]//following::input[1])[1]")
	@CacheLookup
	WebElement dd_TimeOfBirth;
	
	@FindBy(xpath="(//*[contains(text(),'Nakshatra')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Nakshatra;
	
	@FindBy(xpath="(//*[contains(text(),'Nakshatra')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Nakshatra;
	
	@FindBy(xpath="(//*[contains(text(),'Gothram')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Gothram;
	
	@FindBy(xpath="(//*[contains(text(),'Gothram')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Gothram;
	
	@FindBy(xpath="(//*[contains(text(),'Zodiac')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Zodiac;
	
	@FindBy(xpath="(//*[contains(text(),'Zodiac')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Zodiac;
	
	@FindBy(xpath="(//*[contains(text(),'Rashi')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Rashi;
	
	@FindBy(xpath="(//*[contains(text(),'Rashi')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Rashi;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary'])[2]")
	@CacheLookup
	WebElement btn_SaveAstrologyDetails;
	
	public void ClickOn_AstrologyDetails_Icon() throws InterruptedException
	{
		icon_AstrologyDetails.click();
		Thread.sleep(2000);
	}
	public void setPlaceOfBirth(String PlaceOfBirth) throws InterruptedException
	{
		field_PlaceOfBirth.click();
		Thread.sleep(2000);
		dd_PlaceOfBirth.sendKeys(PlaceOfBirth);
		Thread.sleep(2000);
		dd_PlaceOfBirth.sendKeys(Keys.ENTER);
	}
	public void setTimeOfBirth(String TimeOfBirth) throws InterruptedException
	{
		field_TimeOfBirth.click();
		Thread.sleep(2000);
		dd_TimeOfBirth.sendKeys(TimeOfBirth);
		Thread.sleep(2000);
		dd_TimeOfBirth.sendKeys(Keys.ENTER);
	}
	
	public void setNakshatra(String Nakshatra) throws InterruptedException
	{
		field_Nakshatra.click();
		Thread.sleep(2000);
		dd_Nakshatra.sendKeys(Nakshatra);
		Thread.sleep(2000);
		dd_Nakshatra.sendKeys(Keys.ENTER);
	}
	
	public void setGothram(String Gothram) throws InterruptedException
	{
		field_Gothram.click();
		Thread.sleep(2000);
		dd_Gothram.sendKeys(Gothram);
		Thread.sleep(2000);
		dd_Gothram.sendKeys(Keys.ENTER);
	}
	
	public void setZodiac(String Zodiac) throws InterruptedException
	{
		field_Zodiac.click();
		Thread.sleep(2000);
		dd_Zodiac.sendKeys(Zodiac);
		Thread.sleep(2000);
		dd_Zodiac.sendKeys(Keys.ENTER);
	}
	
	public void setRashi(String Rashi) throws InterruptedException
	{
		field_Rashi.click();
		Thread.sleep(2000);
		dd_Rashi.sendKeys(Rashi);
		Thread.sleep(2000);
		dd_Rashi.sendKeys(Keys.ENTER);
	}
	
	public void SaveAstrologyDetails()
	{
		btn_SaveAstrologyDetails.click();
	}
	
	//--------------- Lifestyle Preference -------------------------------------------------------
	
	@FindBy(xpath="//a[@class='edit-lifestyle-preference']")
	@CacheLookup
	WebElement icon_LifestylePreference;
	
	@FindBy(xpath="(//*[contains(text(),'Smoking')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Smoking;
	
	@FindBy(xpath="(//*[contains(text(),'Smoking')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Smoking;
	
	@FindBy(xpath="(//*[contains(text(),'Drinking')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Drinking;
	
	@FindBy(xpath="(//*[contains(text(),'Drinking')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Drinking;
	
	@FindBy(xpath="(//*[contains(text(),'Food Habits')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_FoodHabits;
	
	@FindBy(xpath="(//*[contains(text(),'Food Habits')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_FoodHabits;
	
	@FindBy(xpath="(//*[contains(text(),'House Living in')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_HouseLivingIn;
	
	@FindBy(xpath="(//*[contains(text(),'House Living in')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_HouseLivingIn;
	
	@FindBy(xpath="(//*[contains(text(),'Want kids')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_WantKids;
	
	@FindBy(xpath="(//*[contains(text(),'Want kids')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_WantKids;
	
	@FindBy(xpath="((//*[contains(text(),'Vehicles Owned')])[1]//following::div[1]//following::div[2])[1]")
	@CacheLookup
	WebElement field_VehiclesOwned;
	
	@FindBy(xpath="(//*[contains(text(),'Vehicles Owned')])[1]//following::input[1]")
	@CacheLookup
	WebElement dd_VehiclesOwned;
	
	@FindBy(xpath="((//*[contains(text(),'Vehicles Owned')])[1]//following::div[1]//following::div[2])[5]")
	@CacheLookup
	WebElement field_VehiclesOwned2;
	
	@FindBy(xpath="(//*[contains(text(),'Vehicles Owned')])[1]//following::input[2]")
	@CacheLookup
	WebElement dd_VehiclesOwned2;
	
	@FindBy(xpath="(//*[contains(text(),'Pets')])[2]//following::div[1]")
	@CacheLookup
	WebElement field_Pets;
	
	@FindBy(xpath="(//*[contains(text(),'Pets')])[2]//following::input[1]")
	@CacheLookup
	WebElement dd_Pets;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary '])[3]")
	@CacheLookup
	WebElement btn_SaveLifestylePreference;
	
	public void ClickOn_LifestylePreference_Icon() throws InterruptedException
	{
		icon_LifestylePreference.click();
		Thread.sleep(2000);
	}
	public void setSmoking(String Smoking)
	{
		field_Smoking.click();
		dd_Smoking.sendKeys(Smoking);
		dd_Smoking.sendKeys(Keys.ENTER);
	}
	
	public void setDrinking(String Drinking)
	{
		field_Drinking.click();
		dd_Drinking.sendKeys(Drinking);
		dd_Drinking.sendKeys(Keys.ENTER);
	}
	public void setFoodHabits(String FoodHabits)
	{
		field_FoodHabits.click();
		dd_FoodHabits.sendKeys(FoodHabits);
		dd_FoodHabits.sendKeys(Keys.ENTER);
	}
	public void setHouseLivingIn(String HouseLivingIn)
	{
		field_HouseLivingIn.click();
		dd_HouseLivingIn.sendKeys(HouseLivingIn);
		dd_HouseLivingIn.sendKeys(Keys.ENTER);
	}	
	public void setWantKids(String WantKids)
	{
		field_WantKids.click();
		dd_WantKids.sendKeys(WantKids);
		dd_WantKids.sendKeys(Keys.ENTER);
	}
	public void setVehiclesOwned(String VehiclesOwned)
	{
		field_VehiclesOwned.click();
		dd_VehiclesOwned.sendKeys(VehiclesOwned);
		dd_VehiclesOwned.sendKeys(Keys.ENTER);
	}
	public void setVehiclesOwned2(String VehiclesOwned2)
	{
		field_VehiclesOwned2.click();
		dd_VehiclesOwned2.clear();
		dd_VehiclesOwned2.sendKeys(VehiclesOwned2);
		dd_VehiclesOwned2.sendKeys(Keys.ENTER);
	}
	public void setPets(String Pets)
	{
		field_Pets.click();
		dd_Pets.sendKeys(Pets);
		dd_Pets.sendKeys(Keys.ENTER);
	}
	public void SaveLifestylePreference()
	{
		btn_SaveLifestylePreference.click();
	}
	
	//--------------- Hobbies ----------------------------------------------------------------
	
	@FindBy(xpath="//a[@class='edit-hobbies']")
	@CacheLookup
	WebElement icon_hobbies;
	
	@FindBy(xpath="//input[@value='100002987']")
	@CacheLookup
	WebElement chkArtHandicraft;
	
	@FindBy(xpath="//input[@value='100002988']")
	@CacheLookup
	WebElement chkAutoRacing;
	
	@FindBy(xpath="//input[@value='100002989']")
	@CacheLookup
	WebElement chkBasketball;
	
	@FindBy(xpath="(//*[@class='btn saveto_profile btn-primary'])[3]")
	@CacheLookup
	WebElement btn_SaveHobbies;
	
	public void ClickOn_hobbies_Icon() throws InterruptedException
	{
		icon_hobbies.click();
		Thread.sleep(2000);
	}
	public void ClickOnchkArtHandicraft()
	{
		chkArtHandicraft.click();
	}
	public void ClickOnchkAutoRacing()
	{
		chkAutoRacing.click();
	}
	public void ClickOnchkBasketball()
	{
		chkBasketball.click();
	}
	
	public void SaveHobbies()
	{
		btn_SaveHobbies.click();
	}
	
//	================ Edit Family Section ============================
	@FindBy(id="uncontrolled-tab-example-tab-family")
	@CacheLookup
	WebElement tabFamily;
	
	@FindBy(xpath="//a[@class='edit-family']")
	@CacheLookup
	WebElement btnEditFamilybackgroundIcon;
	
	@FindBy(name="quetionsAnswer2")
	@CacheLookup
	WebElement txtFamilyToMeIs;
	
	@FindBy(xpath="(//*[contains(text(),'Gon')])[11]//following::input[1]")
	@CacheLookup
	WebElement fieldGon;
	
	@FindBy(xpath="(//*[contains(text(),'Family origin')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFamilyOrigin;
	
	@FindBy(xpath="(//*[contains(text(),'Home town')])[2]//following::input[1]")
	@CacheLookup
	WebElement txtHomeTown;
	
	@FindBy(xpath="(//*[contains(text(),'Family Type')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFamilyType;
	
	@FindBy(xpath="(//*[contains(text(),'Family status')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFamilyStatus;
	
	@FindBy(xpath="(//*[contains(text(),'Family Income')])[2]")
	@CacheLookup
	WebElement ddFamilyIncome;
	
	@FindBy(xpath="(//*[contains(text(),'Family Income')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFamilyIncome;
	
	@FindBy(xpath="(//*[contains(text(),'Family value')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFamilyValue;
	
	@FindBy(xpath="(//*[contains(text(),'Father status')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFatherStatus;
	
	
	@FindBy(xpath="(//*[contains(text(),'Father occupation')])[2]")
	@CacheLookup
	WebElement ddFatherOccupation;
	@FindBy(xpath="(//*[contains(text(),'Father occupation')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldFatherOccupation;
	
	@FindBy(xpath="(//*[contains(text(),'Mother status')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldMotherStatus;
	
	@FindBy(xpath="(//*[contains(text(),'Mother occupation')])[2]//following::input[1]")
	@CacheLookup
	WebElement fieldMotherOccupation;
	
	@FindBy(xpath="(//button[@class='btn btn-primary saveto_profile'])[4]")
	@CacheLookup
	WebElement btnSaveFamilyDetails;
	
	public void clickOnFamilySection() 
	{
		tabFamily.click();
	}
	public void clickEditFamilySection() 
	{
		btnEditFamilybackgroundIcon.click();
	}
	public void setFamilyToMeIs(String FamilyToMeIs) 
	{
		txtFamilyToMeIs.click();
		txtFamilyToMeIs.clear();
		txtFamilyToMeIs.sendKeys(FamilyToMeIs);
	}
	
	public void setGon(String GON) 
	{
		fieldGon.click();
		fieldGon.sendKeys(GON);
		fieldGon.sendKeys(Keys.ENTER);
	}
	public void setFamilyOrigin(String FamilyOrigin) 
	{
		fieldFamilyOrigin.click();
		fieldFamilyOrigin.sendKeys(FamilyOrigin);
		fieldFamilyOrigin.sendKeys(Keys.ENTER);
	}
	public void setHomeTown(String HomeTown) 
	{
		txtHomeTown.click();
		txtHomeTown.clear();
		txtHomeTown.sendKeys(HomeTown);
		//txtHomeTown.sendKeys(Keys.ENTER);
	}
	public void setFamilyType(String FamilyType) throws InterruptedException 
	{
		fieldFamilyType.click();
		Thread.sleep(2000);
		fieldFamilyType.sendKeys(FamilyType);
		fieldFamilyType.sendKeys(Keys.ENTER);
	}
	public void setFamilyStatus(String FamilyStatus) 
	{
		fieldFamilyStatus.click();
		fieldFamilyStatus.sendKeys(FamilyStatus);
		fieldFamilyStatus.sendKeys(Keys.ENTER);
	}
	public void setFamilyIncome(String FamilyIncome) throws InterruptedException 
	{
		ddFamilyIncome.click();
		fieldFamilyIncome.sendKeys(FamilyIncome);
		fieldFamilyIncome.sendKeys(Keys.ENTER);
	}
	public void setFamilyValue(String FamilyValue) 
	{
		fieldFamilyValue.click();
		fieldFamilyValue.sendKeys(FamilyValue);
		fieldFamilyValue.sendKeys(Keys.ENTER);
	}
	public void setFatherStatus(String FatherStatus) 
	{
		fieldFatherStatus.click();
		fieldFatherStatus.sendKeys(FatherStatus);
		fieldFatherStatus.sendKeys(Keys.ENTER);
		fieldFatherStatus.sendKeys(Keys.TAB);
	}
	public void setFatherOccupation(String FatherOccupation) throws InterruptedException 
	{
		ddFatherOccupation.click();
		Thread.sleep(2000);
		fieldFatherOccupation.sendKeys(FatherOccupation);
		fieldFatherOccupation.sendKeys(Keys.ENTER);
	}
	public void setMotherStatus(String MotherStatus) 
	{
		fieldMotherStatus.click();
		fieldMotherStatus.sendKeys(MotherStatus);
		fieldMotherStatus.sendKeys(Keys.ENTER);
	}
	public void setMotherOccupation(String MotherOccupation) 
	{
		fieldMotherOccupation.click();
		fieldMotherOccupation.sendKeys(MotherOccupation);
		fieldMotherOccupation.sendKeys(Keys.ENTER);
	}
	public void SaveFamilyDetails()
	{
		btnSaveFamilyDetails.click();
	}
}
