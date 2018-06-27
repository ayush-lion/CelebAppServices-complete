package com.ctn.celebApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ctn.celebApp.entity.AboutMe;
import com.ctn.celebApp.entity.Collaboration;
import com.ctn.celebApp.entity.Fanboard;
import com.ctn.celebApp.entity.FeedBack;
import com.ctn.celebApp.entity.FitnessRoutine;
import com.ctn.celebApp.entity.MediaCaption;
import com.ctn.celebApp.entity.MyDiet;
import com.ctn.celebApp.entity.MyProfile;
import com.ctn.celebApp.entity.NewsFeed;
import com.ctn.celebApp.entity.NewsFeedLikeDetails;
import com.ctn.celebApp.entity.PostUrl;
import com.ctn.celebApp.entity.PostVideos;
import com.ctn.celebApp.entity.Quizgame;
import com.ctn.celebApp.entity.Schedule;
import com.ctn.celebApp.entity.Stats;
import com.ctn.celebApp.entity.Subscribe;
import com.ctn.celebApp.entity.Tournament;
import com.ctn.celebApp.entity.UserCommentDetails;
import com.ctn.celebApp.entity.VideoUrl;
import com.ctn.celebApp.service.UserService;
import com.ctn.celebApp.userrequest.UserCommentRequest;
import com.ctn.celebApp.userrequest.EmailRequest;
import com.ctn.celebApp.userrequest.LikeRequest;
import com.ctn.celebApp.userrequest.LoginWithFacebookRequest;
import com.ctn.celebApp.userrequest.LoginWithGoogle;
import com.ctn.celebApp.userrequest.PostUrlRequest;
import com.ctn.celebApp.userrequest.QuizGameRequest;
import com.ctn.celebApp.userrequest.UserCreateRequest;
import com.ctn.celebApp.userrequest.UserLoginRequest;
import com.ctn.celebApp.userrequest.VideoUrlRequest;
import com.ctn.celebApp.userresponse.NewsFeedResponse;
import com.ctn.celebApp.userresponse.StatusResponse;
import com.ctn.celebApp.userresponse.UserCommentResponse;
import com.ctn.celebApp.userresponse.UserDetailsResponse;
import com.ctn.celebApp.userresponse.UserQuizResponse;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	/**************************************** Create A User ***********************************************/

	@RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
	public UserDetailsResponse userCreation(@RequestBody UserCreateRequest userCreateRequest) {
		
	return userService.create(userCreateRequest);
	}

	/**************************************** Login A User ************************************************/

	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
	public UserDetailsResponse login(@RequestBody UserLoginRequest userLoginRequest) {

	return userService.login(userLoginRequest);
	}

	/**************************************** Login With Facebook *****************************************/

	@RequestMapping(value = "/loginWithFacebook", produces = "application/json", method = RequestMethod.POST)
	public UserDetailsResponse loginWithFacebook(@RequestBody LoginWithFacebookRequest loginWithFacebookRequest) {

	return userService.loginWithFacebook(loginWithFacebookRequest);
	}
	
	/**************************************** Login With Google *******************************************/
	
	@RequestMapping(value = "/loginWithGoogle", produces = "application/json", method = RequestMethod.POST)
	public UserDetailsResponse loginWithGoogle(@RequestBody LoginWithGoogle loginWithGoogle) {
		
	return userService.loginWithGoogle(loginWithGoogle);
	}
	
	/***************************************** ChooseQuiz **********************************************/
	@RequestMapping(value="/quizChoose", produces = "application/json", method = RequestMethod.POST)
	public UserQuizResponse saveQuizAnswer(@RequestBody QuizGameRequest request) {
	
	return userService.saveQuizAnswer(request);	
	}
	
	/**************************************** Quiz ******************************************************/
	
	@RequestMapping(value="/quiz", produces = "application/json", method = RequestMethod.GET)
	public List <Quizgame> findquiz(){
		
	return userService.findquiz();	
	}
	
	/****************************************** MediaCaption **********************************************/
	@RequestMapping(value = "/mediaCaption", produces = "application/json", method = RequestMethod.GET)
	public List<MediaCaption> mediaCaption(){
	
	return userService.mediaCaption();
	}
	
	/****************************************** schedule ****************************************************/
	
	@RequestMapping(value = "/schedule", produces = "application/json", method = RequestMethod.GET)
	public List<Schedule> findSchedule(){
	
	return userService.findSchedule();	
	}
	
	/****************************************** mydiet ****************************************************/
		
	@RequestMapping(value = "/mydiet", produces = "application/json", method = RequestMethod.GET)
	public List<MyDiet> myDiet(){
			
	return userService.myDiet();
	}
	
	@RequestMapping(value = "/youtube", produces = "application/json", method = RequestMethod.GET)
	public List<VideoUrl> findVideoUrl(){
		
	return userService.findVideoUrl();	
	}
	
	/**************************************** international ***********************************************/
	@RequestMapping(value = "/international", produces ="application/json", method = RequestMethod.GET)
	public List<Tournament> findInternationalUrl(){
	
	return userService.findInternationalUrl();	
	}
	
	/**************************************** domestic ***********************************************/
	@RequestMapping(value = "/domestic", produces ="application/json", method = RequestMethod.GET)
	public List<Tournament> findDomesticUrl(){
	
	return userService.findDomesticUrl();	
	}
	
	/*************************************** Tournament stats *************************************************/
	@RequestMapping(value = "/stats/{id}", method = RequestMethod.GET)
	public List<Stats> findById(@PathVariable Integer id){
	List<Stats> stat = new 	ArrayList<>();
	List<Stats> stats = userService.findAllStats();
	for (Stats stats2 : stats) {
		if (stats2.getId()==id) {
			stat.add(stats2);
			break;
		}
	}
	return 	stat;
	}
	
	/**************************************** Aboutme Celebrity *******************************************************/
	
	@RequestMapping(value = "/aboutme",produces = "application/json",method = RequestMethod.GET)
	public List<AboutMe> aboutme() {
		
	return userService.aboutme();
	}
	
	/****************************************  MyProfile  *******************************************************/
	
	@RequestMapping(value = "/myprofile",produces = "application/json",method = RequestMethod.GET)
	public List<MyProfile> myprofile() {
			
	return userService.myprofile();
	}
	
	/***************************************** Feedback *********************************************************/
	@RequestMapping(value = "/feedback" , produces = "application/json", method = RequestMethod.GET)
	public List<FeedBack> findFeedback(){
	
	return userService.findFeedback();	
	}
	
		
	/***************************************** Fanboard *********************************************************/
		
	@RequestMapping(value = "/fanboard" , produces = "application/json",method = RequestMethod.GET)
	public List<Fanboard> findAllFan(){
			
	return userService.findAllFan();
	}
		
	/***************************************** Collaboration *********************************************************/
		
	@RequestMapping(value = "/collaborations" , produces = "application/json",method = RequestMethod.GET)
	public List<Collaboration> collaborations(){
			
	return userService.collaborations();
	}
		
	/****************************************** FitnessRoutine ****************************************************/
		
	@RequestMapping(value = "/fitnessroutine", produces = "application/json", method = RequestMethod.GET)
	public List<FitnessRoutine> fitnessRoutine(){
			
	return userService.fitnessRoutine();
	}
		
	/****************************************** Subscribe **************************************************/
		
	@RequestMapping(value = "/subscribe", produces = "application/json", method = RequestMethod.GET)
	public List<Subscribe> subscribe(){
			
	return userService.subscribe();
	}
	
	/******************************************** News Feed Like ********************************************/
	
	@RequestMapping(value="/NewsFeedLike", method=RequestMethod.POST)
	public ResponseEntity<?> NewsFeedLike(@RequestBody LikeRequest likeRequest){

	return userService.NewsFeedLike(likeRequest);
	}
	
	/***************************************** Comment Post ***************************************************/
	
	@RequestMapping(value ="/PostComment", method = RequestMethod.POST)
	public ResponseEntity<?> UserComment(@RequestBody UserCommentRequest commentRequest){

	return userService.UserComment(commentRequest);	
	}
	
	/******************************************** News Feed ********************************************/
	
	@RequestMapping(value="/newsFeed/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> likeStatusAllfeed(@PathVariable Integer userId){

	return userService.LikeStatusAllfeed(userId);	
	}
	
    /******************************************** Comment ********************************************/
	
	@RequestMapping(value ="/getComment/{newsFeedId}",method = RequestMethod.GET)
	public ResponseEntity<?> getComment(@PathVariable Integer newsFeedId){
		
	return userService.getAllComment(newsFeedId);	
	}
	
	/****************************************** Forgot Password *******************************************/
	
	@RequestMapping(value = "/forgotPassword",  produces = "application/json", method = RequestMethod.PUT)
	public StatusResponse forgotPassword(@RequestBody EmailRequest emailRequest) {
		
	return userService.forgotPassword(emailRequest);
	}
	
	/*************************************** save Post Link *************************************************/
	
	@RequestMapping(value = "/savepost" , produces = "application/json", method = RequestMethod.POST)
	public List<PostUrl> savePostUrl(@RequestBody PostUrlRequest postUrlRequest){
	
	return (List<PostUrl>) userService.savePostUrl(postUrlRequest);	
	}
	
	/*************************************** save youtube videos ******************************************/
	
	@RequestMapping(value = "saveyoutube", produces = "application/json" , method = RequestMethod.POST)
	public List<PostVideos> saveVideo(@RequestBody VideoUrlRequest videoUrlRequest ){
		
	return (List<PostVideos>) userService.saveVideo(videoUrlRequest);			
	}
	
	/**************************************** set Profile pic ******************************************/
	
	@RequestMapping(value="/setProfilePic", method=RequestMethod.POST)
	public ResponseEntity<?> uploadProfilePic(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile file){

	return userService.setProfilePic(userId,file);
	}

	/**************************************** Set/Edit Other Profile Pic **************************************/
	
	@RequestMapping(value = "/setOtherProfilePic/{profilePicId}", method = RequestMethod.PUT)
	public StatusResponse setOtherProfilePic(@PathVariable("profilePicId") Integer profilepicId) {
		
	return userService.setOtherProfilePic(profilepicId);
	}
}