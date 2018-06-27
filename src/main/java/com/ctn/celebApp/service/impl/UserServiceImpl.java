package com.ctn.celebApp.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ctn.celebApp.dao.AboutMeRepository;
import com.ctn.celebApp.dao.CelebRepository;
import com.ctn.celebApp.dao.CollaborationRepository;
import com.ctn.celebApp.dao.FanBoardRepository;
import com.ctn.celebApp.dao.FeedBackRepository;
import com.ctn.celebApp.dao.FitnessRoutineRepository;
import com.ctn.celebApp.dao.LikeStatusAllFeedRepository;
import com.ctn.celebApp.dao.MediaCaptionRepository;
import com.ctn.celebApp.dao.MyDietRepository;
import com.ctn.celebApp.dao.NewsFeedLikeRepository;
import com.ctn.celebApp.dao.NewsFeedRepo;
import com.ctn.celebApp.dao.PostUrlRepo;
import com.ctn.celebApp.dao.PostVideoRepo;
import com.ctn.celebApp.dao.ProfilePicRepository;
import com.ctn.celebApp.dao.QuizAnswerRepository;
import com.ctn.celebApp.dao.QuizRepository;
import com.ctn.celebApp.dao.ScheduleRepository;
import com.ctn.celebApp.dao.StatsRepository;
import com.ctn.celebApp.dao.SubscribeRepository;
import com.ctn.celebApp.dao.TournamentRepository;
import com.ctn.celebApp.dao.UserCommentRepository;
import com.ctn.celebApp.dao.UserRepository;
import com.ctn.celebApp.dao.VideoUrlRepository;
import com.ctn.celebApp.entity.AboutMe;
import com.ctn.celebApp.entity.CelebDetails;
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
import com.ctn.celebApp.entity.ProfilePic;
import com.ctn.celebApp.entity.QuizAnswer;
import com.ctn.celebApp.entity.Quizgame;
import com.ctn.celebApp.entity.Schedule;
import com.ctn.celebApp.entity.Stats;
import com.ctn.celebApp.entity.Subscribe;
import com.ctn.celebApp.entity.Tournament;
import com.ctn.celebApp.entity.User;
import com.ctn.celebApp.entity.UserCommentDetails;
import com.ctn.celebApp.entity.VideoUrl;
import com.ctn.celebApp.enums.Status;
import com.ctn.celebApp.service.GenerateRandomPassword;
import com.ctn.celebApp.service.MailSender;
import com.ctn.celebApp.service.UserService;
import com.ctn.celebApp.userrequest.EmailRequest;
import com.ctn.celebApp.userrequest.LikeRequest;
import com.ctn.celebApp.userrequest.LoginWithFacebookRequest;
import com.ctn.celebApp.userrequest.LoginWithGoogle;
import com.ctn.celebApp.userrequest.PostUrlRequest;
import com.ctn.celebApp.userrequest.QuizGameRequest;
import com.ctn.celebApp.userrequest.UserCommentRequest;
import com.ctn.celebApp.userrequest.UserCreateRequest;
import com.ctn.celebApp.userrequest.UserLoginRequest;
import com.ctn.celebApp.userrequest.VideoUrlRequest;
import com.ctn.celebApp.userresponse.LikeResponse;
import com.ctn.celebApp.userresponse.NewsFeedResponse;
import com.ctn.celebApp.userresponse.StatusResponse;
import com.ctn.celebApp.userresponse.UserCommentResponse;
import com.ctn.celebApp.userresponse.UserDetailsResponse;
import com.ctn.celebApp.userresponse.UserQuizResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	CelebRepository celebRepo;

	@Autowired
	ProfilePicRepository profileRepo;

	@Autowired
	PostUrlRepo postUrlRepo;

	@Autowired
	GenerateRandomPassword genratedRandomPassword;

	@Autowired
	MailSender mailSender;

	@Autowired
	PostVideoRepo postVideoRepo;
	
	@Autowired
	NewsFeedLikeRepository newsFeedLikeRepo;

	@Autowired
	AboutMeRepository aboutMeRepo;
	
	@Autowired
	UserCommentRepository userCommentRepo;
	
	@Autowired
	MediaCaptionRepository mediaCaptionRepo;
	
	@Autowired
	FeedBackRepository feedBackRepo;

	@Autowired
	FanBoardRepository fanBoardRepo;

	@Autowired
	SubscribeRepository subscribeRepo;

	@Autowired
	FitnessRoutineRepository fitnessRoutineRepo;

	@Autowired
	CollaborationRepository collaborationRepo;
	
	@Autowired
	NewsFeedRepo newsFeedRepo;
	
	@Autowired
	TournamentRepository tournamentRepo;
	
	@Autowired
	StatsRepository statsRepo;

	@Autowired
	MyDietRepository myDietRepo;
	
	@Autowired
	ScheduleRepository scheduleRepo;
	
	@Autowired
	QuizRepository quizRepo;
	
	@Autowired
	VideoUrlRepository videourlRepo;
	
	@Autowired
	LikeStatusAllFeedRepository likeStatusAllFeedRepo;
	
	@Autowired
	QuizAnswerRepository quizAnswerRepo;
	
	@Override
	public UserDetailsResponse create(UserCreateRequest userCreateRequest) {
		UserDetailsResponse response = new UserDetailsResponse();
		final User user = userRepo.findByEmail(userCreateRequest.getEmail());

		if (user != null) {
			response.setStatus(Status.FAILED);
			response.setMessage("Email is not valid or Email Exist Allready!!");
			return response;
		} else {
			final User newUser = new User();
			newUser.setUserName(userCreateRequest.getUserName());
			newUser.setEmail(userCreateRequest.getEmail());
			newUser.setPassword(userCreateRequest.getPassword());

			userRepo.save(newUser);

			response.setUserName(userCreateRequest.getUserName());
			response.setEmail(userCreateRequest.getEmail());
			response.setStatus(Status.SUCCESS);
			response.setMessage("Details Saved Sucessfully!!");
			return response;
		}
	}
	
	@Override
	public List<PostUrl> savePostUrl(PostUrlRequest postUrlRequest) {
		List<PostUrl> requestList = new ArrayList<>();
		final List<PostUrl> postUrl = postUrlRepo.findByUserId(postUrlRequest.getUserId());
		List<String> postlist = postUrlRequest.getPostUrl();
		List<String> urlList = new ArrayList<>();

		if (postUrl.size() == 0) {
			for (String string : postlist) {
				PostUrl newpostUrl = new PostUrl();
				newpostUrl.setPostUrl(string);
				newpostUrl.setUserId(postUrlRequest.getUserId());
				postUrlRepo.save(newpostUrl);
				requestList.add(newpostUrl);
			}
		} else {
			for (PostUrl string : postUrl) {
				urlList.add(string.getPostUrl());
			}
			for (String posturls : postlist) {
				if (urlList.contains(posturls)) {
					System.out.println("already available");
				} else {
					PostUrl newpostUrl = new PostUrl();
					newpostUrl.setPostUrl(posturls);
					newpostUrl.setUserId(postUrlRequest.getUserId());
					postUrlRepo.save(newpostUrl);
					requestList.add(newpostUrl);
				}
			}
		}
		 List<PostUrl> postUrl2 = postUrlRepo.findByUserId(postUrlRequest.getUserId());
		 Collections.reverse(postUrl2);
		return  postUrl2;	
	}
	
	@Override
	public List<PostVideos> saveVideo(VideoUrlRequest videoUrlRequest) {
		List<PostVideos> requestList = new ArrayList<>();
		final List<PostVideos> postUrl = postVideoRepo.findByUserId(videoUrlRequest.getUserId());
		List<String> postlist = videoUrlRequest.getVideo();
		List<String> urlList = new ArrayList<>();
		if (postUrl.size() == 0) {
			for (String string : postlist) {
				PostVideos newpostUrl = new PostVideos();
				newpostUrl.setVideoUrl(string);
				newpostUrl.setUserId(videoUrlRequest.getUserId());
				postVideoRepo.save(newpostUrl);
				requestList.add(newpostUrl);				
			}
		} else {
			for (PostVideos string : postUrl) {
				urlList.add(string.getVideoUrl());
			}
			for (String posturls : postlist) {
				if (urlList.contains(posturls)) {
					System.out.println("already available");
				} else {
					PostVideos newpostUrl = new PostVideos();
					newpostUrl.setVideoUrl(posturls);
					newpostUrl.setUserId(videoUrlRequest.getUserId());

					postVideoRepo.save(newpostUrl);

					requestList.add(newpostUrl);
				}
			}
		}
		List<PostVideos> postUrl2 = postVideoRepo.findByUserId(videoUrlRequest.getUserId());
		Collections.reverse(postUrl2);
		return  postUrl2;		
	}

	@Override
	public UserDetailsResponse login(UserLoginRequest userLoginRequest) {

		String oldPassword = userLoginRequest.getPassword();
		final User user = userRepo.findByEmail(userLoginRequest.getEmail());

		UserDetailsResponse userLoginResponse = new UserDetailsResponse();

		if (user == null) {
			userLoginResponse.setStatus(Status.FAILED);
			userLoginResponse.setMessage("Email or password doesnt exist.");
			return userLoginResponse;
		}

		if (!user.getPassword().equals(oldPassword)) {
			userLoginResponse.setStatus(Status.FAILED);
			userLoginResponse.setMessage("Email or password doesnt exist.");
			return userLoginResponse;
		}

		userLoginResponse.setUserId(user.getUserId());
		userLoginResponse.setUserName(user.getUserName());
		userLoginResponse.setEmail(user.getEmail());
		userLoginResponse.setPassword(user.getPassword());
		userLoginResponse.setStatus(Status.SUCCESS);
		userLoginResponse.setMessage("Logged In Successfully");
		return userLoginResponse;
	}

	@Override
	public UserDetailsResponse loginWithFacebook(LoginWithFacebookRequest loginWithFacebookRequest) {

		User u = userRepo.findByEmail(loginWithFacebookRequest.getEmail());
		if (u == null) {
			User newUser = new User();

			newUser.setEmail(loginWithFacebookRequest.getEmail());
			newUser.setUserName(loginWithFacebookRequest.getUsername());
			newUser.setSocialMedia(true);

			userRepo.save(newUser);

			UserDetailsResponse uLR = new UserDetailsResponse();
			uLR.setUserId(userRepo.save(newUser).getUserId());
			uLR.setEmail(loginWithFacebookRequest.getEmail());
			uLR.setUserName(loginWithFacebookRequest.getUsername());
			uLR.setStatus(Status.SUCCESS);
			uLR.setMessage("Details Saved Successfully!!");
			return uLR;
		}
		UserDetailsResponse sR = new UserDetailsResponse();
		sR.setUserId(u.getUserId());
		sR.setUserName(u.getUserName());
		sR.setEmail(u.getEmail());
		sR.setStatus(Status.SUCCESS);
		sR.setMessage("Details Saved Allready");
		return sR;
	}

	@Override
	public UserDetailsResponse loginWithGoogle(LoginWithGoogle loginWithGoogle) {

		User u = userRepo.findByEmail(loginWithGoogle.getEmail());
		if (u == null) {
			User newUser = new User();

			newUser.setEmail(loginWithGoogle.getEmail());
			newUser.setUserName(loginWithGoogle.getUserName());
			newUser.setSocialMedia(true);

			userRepo.save(newUser);

			UserDetailsResponse uLR = new UserDetailsResponse();
			uLR.setUserId(userRepo.save(newUser).getUserId());
			uLR.setEmail(loginWithGoogle.getEmail());
			uLR.setUserName(loginWithGoogle.getUserName());
			uLR.setStatus(Status.SUCCESS);
			uLR.setMessage("Details Saved Successfully!!");
			return uLR;
		}
		UserDetailsResponse sR = new UserDetailsResponse();
		sR.setUserId(u.getUserId());
		sR.setUserName(u.getUserName());
		sR.setEmail(u.getEmail());
		sR.setStatus(Status.SUCCESS);
		sR.setMessage("Details Saved Allready");
		return sR;
	}

	@Override
	public StatusResponse forgotPassword(EmailRequest emailRequest) {
		User u = userRepo.findByEmail(emailRequest.getEmail());
		if (u == null) {
			StatusResponse sR = new StatusResponse();
			sR.setStatus(Status.FAILED);
			sR.setMessage("Email Doesn't Exist");
			return sR;
		}
		String newPass = genratedRandomPassword.RandomPassword();
		String from = "aayush4lion@gmail.com";
		String to = "aayush4lion@gmail.com";
		String subject = "Hi ! Welcome to celeb App";
		String body = "New Password: " + newPass;
		mailSender.sendMail(from, to, subject, body);
		u.setPassword(body);
		userRepo.save(u);
		StatusResponse sR = new StatusResponse();
		sR.setStatus(Status.SUCCESS);
		sR.setMessage("New Password Send to Your EmailId!");
		return sR;
	}

	@Override
	public List<AboutMe> aboutme() {

		return (List<AboutMe>) aboutMeRepo.findAll();
	}

	@Override
	public List<MyProfile> myprofile() {
		List<CelebDetails> celeblist = (List<CelebDetails>) celebRepo.findAll();
		List<MyProfile> myprofile = new ArrayList<>();
		MyProfile profile = new MyProfile();
		for (CelebDetails celebDetails : celeblist) {
			profile.setAge(celebDetails.getAge());
			profile.setBattingstyle(celebDetails.getBattingstyle());
			profile.setBowlingstyle(celebDetails.getBowlingstyle());
			profile.setCelebid(celebDetails.getCelebid());
			profile.setCelebname(celebDetails.getCelebname());
			profile.setHeight(celebDetails.getHeight());
			profile.setMajorteams(celebDetails.getMajorteams());
			profile.setMatchplayed(celebDetails.getMatchplayed());
			profile.setOccupation(celebDetails.getOccupation());
			profile.setProfile(celebDetails.getProfile());
			profile.setRun(celebDetails.getRun());
			profile.setWicket(celebDetails.getWicket());
			myprofile.add(profile);
		}
		return myprofile;
	}
	
	@Override
	public List<Fanboard> findAllFan() {
	return (List<Fanboard>) fanBoardRepo.findAll();
	}

	@Override
	public List<Collaboration> collaborations() {
	return (List<Collaboration>) collaborationRepo.findAll();
	}

	@Override
	public List<FitnessRoutine> fitnessRoutine() {
	return (List<FitnessRoutine>) fitnessRoutineRepo.findAll();
	}

	@Override
	public List<MyDiet> myDiet() {
	return (List<MyDiet>) myDietRepo.findAll();
	}
	
	@Override
	public List<MediaCaption> mediaCaption() {
	
	return (List<MediaCaption>)mediaCaptionRepo.findAll();
	}

	@Override
	public List<FeedBack> findFeedback() {	
	return (List<FeedBack>) feedBackRepo.findAll();
	}

	@Override
	public List<Subscribe> subscribe(){ 
	return (List<Subscribe>) subscribeRepo.findAll();
	}
	
	@Override
	public ResponseEntity<?> getAllComment(Integer newsFeedId) {
	List<UserCommentResponse> responses = new ArrayList<>();	
	List<UserCommentDetails> userComment = userCommentRepo.findByNewsFeedId(newsFeedId);
	for (UserCommentDetails userCommentDetails : userComment) {
		UserCommentResponse userCommentResponse = new UserCommentResponse();
		if(userCommentDetails.getNewsFeedId().equals(newsFeedId)) {
			User userdetail = userRepo.findByUserId(userCommentDetails.getUserId());
			userCommentResponse.setUserId(userdetail.getUserId());
			userCommentResponse.setUserName(userdetail.getUserName());
			ProfilePic profilePic = profileRepo.findByUserId(userCommentDetails.getUserId());
			userCommentResponse.setProfilePic(profilePic.getProfilePic());
		}
		userCommentResponse.setNewsFeedId(userCommentDetails.getNewsFeedId());
		userCommentResponse.setComment(userCommentDetails.getComment());
		responses.add(userCommentResponse);
	 }	
	return new ResponseEntity(responses,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> LikeStatusAllfeed(Integer userId) {
	int count = 0;
	List<NewsFeed> newsFeedUrl = newsFeedRepo.findAll();
	List<NewsFeedResponse> responses = new ArrayList<>();
	for (NewsFeed newsFeed : newsFeedUrl) {
		NewsFeedResponse newsFeedResponse =new NewsFeedResponse(); 
		newsFeedResponse.setNewsFeedId(newsFeed.getNewsFeedId());
		newsFeedResponse.setNewsFeedUrl(newsFeed.getNewsFeedUrl());		
		List<NewsFeedLikeDetails> newsFeedStatus = likeStatusAllFeedRepo.findByNewsFeedId(newsFeed.getNewsFeedId());
		if(newsFeedStatus.size()!=0) {
		for (NewsFeedLikeDetails newsFeedLikeDetails : newsFeedStatus) {
			count=newsFeedStatus.get(newsFeedStatus.size()-1).getLikeCount();
		  List<NewsFeedLikeDetails> userIdList=likeStatusAllFeedRepo.findByUserId(userId);	
			for (NewsFeedLikeDetails newsFeedLikeDetails2 : userIdList) {
				if(userId.equals(newsFeedLikeDetails2.getUserId()) && newsFeedLikeDetails.getNewsFeedId().equals(newsFeedLikeDetails2.getNewsFeedId())) {		
				 newsFeedResponse.setUserId(newsFeedLikeDetails2.getUserId());
				 newsFeedResponse.setLikeType(newsFeedLikeDetails2.getLikeType());
				 newsFeedResponse.setLikeCount(count);
				}
				else
				{
				newsFeedResponse.setLikeCount(count);
				}
			 }
			responses.add(newsFeedResponse);
			break;
		   }
		}
		else 
		{
			responses.add(newsFeedResponse);
		}
	  }
	return new ResponseEntity(responses,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> UserComment(UserCommentRequest commentRequest) {
		UserCommentResponse response = new UserCommentResponse();
	    UserCommentDetails userCommentDetails = new UserCommentDetails();
		userCommentDetails.setUserId(commentRequest.getUserId());
		userCommentDetails.setNewsFeedId(commentRequest.getNewsFeedId());
		userCommentDetails.setComment(commentRequest.getComment());
		userCommentRepo.save(userCommentDetails);
		
		User userDetails = userRepo.findByUserId(commentRequest.getUserId());
		if((userDetails.getUserId()).equals(commentRequest.getUserId()))
		{
			response.setUserName(userDetails.getUserName());
		}	
		
		ProfilePic profileDetails = profileRepo.findByUserId(commentRequest.getUserId());
		if((profileDetails.getUserId()).equals(commentRequest.getUserId()))
		{
			response.setProfilePic(profileDetails.getProfilePic());
		}	
				
		response.setNewsFeedId(userCommentDetails.getNewsFeedId());
		response.setUserId(commentRequest.getUserId());
		response.setComment(commentRequest.getComment());
	return new ResponseEntity<UserCommentResponse>(response,HttpStatus.OK);
	}
	
	@Override
	public UserQuizResponse saveQuizAnswer(QuizGameRequest request) {
		
		QuizAnswer quizAnswer = new QuizAnswer();
		quizAnswer.setQuizId(request.getQuizId());
		quizAnswer.setUserId(request.getUserId());
		quizAnswer.setQuizAnswer(request.getQuizAnswer());
		quizAnswerRepo.save(quizAnswer);
		
		UserQuizResponse response = new UserQuizResponse();
		response.setQuizId(request.getQuizId());
		response.setStatus(Status.SUCCESS);
		return response;
	}

	@Override
	public ResponseEntity<?> NewsFeedLike(LikeRequest likeRequest) {
		int likeCount = 0;
		int disLikeCount = 0;

		List<NewsFeedLikeDetails> pList = newsFeedLikeRepo.findByNewsFeedId(likeRequest.getNewsFeedId());
		for (NewsFeedLikeDetails postLikeDetails : pList) {
			if (postLikeDetails.getUserId().equals(likeRequest.getUserId())) {
				NewsFeedLikeDetails p = newsFeedLikeRepo.findByNewsFeedLikeId(postLikeDetails.getNewsFeedLikeId());
				newsFeedLikeRepo.delete(p);
			}
		}
		NewsFeedLikeDetails pDetails = new NewsFeedLikeDetails();
		pDetails.setNewsFeedId(likeRequest.getNewsFeedId());
		pDetails.setUserId(likeRequest.getUserId());
		pDetails.setLikeType(likeRequest.getLikeType());
		newsFeedLikeRepo.save(pDetails);
		List<NewsFeedLikeDetails> pList1 = newsFeedLikeRepo.findByNewsFeedId(likeRequest.getNewsFeedId());
		for (NewsFeedLikeDetails postLikeDetails : pList1) {
			if (postLikeDetails.getLikeType().equals("LIKE")) {
				likeCount++;
				pDetails.setLikeCount(likeCount);
			} else if (postLikeDetails.getLikeType().equals("DISLIKE") || postLikeDetails.getLikeType().equals(null)) {
				disLikeCount++;
			}
		}
		newsFeedLikeRepo.save(pDetails);
		LikeResponse lR = new LikeResponse();
		lR.setLikeCount(likeCount);
		lR.setDislikeCount(disLikeCount);
		lR.setLikeType(likeRequest.getLikeType());
		lR.setStatus(Status.SUCCESS);
		lR.setMessage("Post " + likeRequest.getLikeType() + " Successfully!!");
		return new ResponseEntity<LikeResponse>(lR, HttpStatus.OK);
	}

	@Override
	public List<Tournament> findInternationalUrl() {
	List<Tournament> path = tournamentRepo.findInternationalUrl();
	return path;
	}
	
	@Override
	public List<Tournament> findDomesticUrl() {
	List<Tournament> path = tournamentRepo.findDomesticUrl();
	return path;
	}

	@Override
	public List<Stats> findAllStats() {
		
	return (List<Stats>) statsRepo.findAll();
	}

	@Override
	public List<Schedule> findSchedule() {
		
	return (List<Schedule>) scheduleRepo.findAll();
	}

	@Override
	public List<VideoUrl> findVideoUrl() {
		
	return (List<VideoUrl>) videourlRepo.findAll();
	}

	@Override
	public List<Quizgame> findquiz() {
		
	return (List<Quizgame>) quizRepo.findAll() ;
	}

	@Override
	public ResponseEntity<?> setProfilePic(Integer userId, MultipartFile file) {
		
	return null;
	}

	@Override
	public StatusResponse setOtherProfilePic(Integer profilepicId) {
	
	return null;
	}

	/*@Override
	public ResponseEntity<?> setProfilePic(Integer userId, MultipartFile file) {
		User u = userRepo.findByUserId(userId);

		if (u == null) {
			StatusResponse sR = new StatusResponse();
			sR.setStatus(Status.FAILED);
			sR.setMessage("UserId doesn't exits !!");
			return new ResponseEntity<StatusResponse>(sR, HttpStatus.NOT_FOUND);
		}

		String fileName = null;
		ProfilePic pp = new ProfilePic();
		String basePath = "src/main/webapp/views/images/Profile_Pic/";

		File dir1 = new File("/src/main/webapp/views/images/Profile_Pic/" + userId);

		// attempt to create the directory here

		dir1.setExecutable(true);
		dir1.setWritable(true);
		dir1.setReadable(true);

		List<ProfilePic> profile = profileRepo.findByUserId(userId);
		for (ProfilePic profilePic : profile) {
			profilePic.setStatus("Inactive");
			profileRepo.save(profilePic);
		}
		if (!file.isEmpty()) {
			try {
				String f = file.getOriginalFilename();
				int i = f.lastIndexOf('.');
				String s = f.substring(i);
				Date d = new Date();
				long n = d.getTime();
				fileName = n + s;
				byte[] bytes = file.getBytes();

				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File(basePath + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				pp.setUserId(userId);
				pp.setProfilePic(fileName);
				pp.setStatus("Active");
				profileRepo.save(pp);
				ProfilePicResponse pPR = new ProfilePicResponse();
				pPR.setProfilePicId(profileRepo.save(pp).getProfilePicId());
				pPR.setProfilePic(fileName);
				pPR.setStatus(Status.SUCCESS);
				pPR.setMessage("You have uploaded Successfully!!");
				return new ResponseEntity<ProfilePicResponse>(pPR, HttpStatus.OK);

			} catch (Exception e) {
				StatusResponse sR = new StatusResponse();
				sR.setStatus(Status.FAILED);
				sR.setMessage("You failed to upload " + fileName + ": " + e.getMessage());
				return new ResponseEntity<StatusResponse>(sR, HttpStatus.NOT_FOUND);
			}
		} else {
			StatusResponse sR = new StatusResponse();
			sR.setStatus(Status.FAILED);
			sR.setMessage("Unable to upload. File is empty.");
			return new ResponseEntity<StatusResponse>(sR, HttpStatus.NO_CONTENT);
		}
	}*/
	
	/*@Override
	public StatusResponse setOtherProfilePic(Integer profilepicId) {
		ProfilePic p = profileRepo.findByProfilePicId(profilepicId);
		if (p == null) {
			StatusResponse sR = new StatusResponse();
			sR.setStatus(Status.FAILED);
			sR.setMessage("The ProfilePicId doesn't Exist");
			return sR;
		}
		List<ProfilePic> pList = profileRepo.findByUserId(p.getUserId());
		for (ProfilePic profilePic : pList) {
			profilePic.setStatus("Inactive");
			profileRepo.save(profilePic);
		}
		p.setStatus("Active");
		profileRepo.save(p);

		StatusResponse sR = new StatusResponse();
		sR.setStatus(Status.SUCCESS);
		sR.setMessage("The Profile Pic Set Successfully!!");
		return sR;
	}*/
}
