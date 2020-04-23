package oss;//package oss;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
//import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
//import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;
//import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
//import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
//import com.aliyuncs.vod.model.v20170321.SubmitTranscodeJobsResponse;
//import com.jiaoyu.entity.dto.BaseDto;
//import com.jiaoyu.service.VideoService;
//import com.jiaoyu.util.ResponseCode;
//import com.jiaoyu.util.VODUtil;
//
///**
// * 视频点播相关接口
// *
// * @author Administrator
// *
// */
//@RestController
//@RequestMapping("/video")
//public class VideoController {
//	@Autowired
//	private VideoService videoService;
//
//	/**
//	 * 上传视频
//	 *
//	 * @param record
//	 * @return
//	 */
//	@RequestMapping("/createUploadVideo")
//	public BaseDto createUploadVideo(@RequestParam Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		CreateUploadVideoResponse response = new CreateUploadVideoResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.createUploadVideo(client, record);
//
//			Map<String, String> dataMap = new HashMap<String, String>();
//			// 设置视频ID
//			dataMap.put("VideoId", response.getVideoId());
//			// 设置视频地址
//			dataMap.put("UploadAddress", response.getUploadAddress());
//			// 设置Auth(许可证???)
//			dataMap.put("UploadAuth", response.getUploadAuth());
//			// 设置请求ID
//			dataMap.put("RequestId", response.getRequestId());
//
////			System.out.print("VideoId = " + response.getVideoId() + "\n");
////			System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
////			System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
////			System.out.print("RequestId = " + response.getRequestId() + "\n");
//			map.put("data", dataMap);
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//		}
//
//	}
//
//	/**
//	 * 获取视频信息
//	 *
//	 * @param record
//	 * @return
//	 */
//	@RequestMapping("/getVideoInfo")
//	public BaseDto getVideoInfo(@RequestParam Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		GetVideoInfoResponse response = new GetVideoInfoResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.getVideoInfo(client, record.get("videoId"));
////			System.out.print("Title = " + response.getVideo().getTitle() + "\n");
////			System.out.print("Description = " + response.getVideo().getDescription() + "\n");
////			System.out.print("RequestId = " + response.getRequestId() + "\n");
//			map.put("data", response);
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//		}
//
//	}
//
//	/**
//	 * 刷新上传
//	 *
//	 * @param record
//	 * @return
//	 */
//	@RequestMapping("/refreshUploadVideo")
//	public BaseDto refreshUploadVideo(@RequestParam Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		RefreshUploadVideoResponse response = new RefreshUploadVideoResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.refreshUploadVideo(client, record);
//
//			Map<String, String> dataMap = new HashMap<String, String>();
//			// 设置视频ID
//			dataMap.put("VideoId", response.getVideoId());
//			// 设置视频地址
//			dataMap.put("UploadAddress", response.getUploadAddress());
//			// 设置Auth(许可证???)
//			dataMap.put("UploadAuth", response.getUploadAuth());
//			// 设置请求ID
//			dataMap.put("RequestId", response.getRequestId());
//
////			System.out.print("VideoId = " + response.getVideoId() + "\n");
////			System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
////			System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
////			System.out.print("RequestId = " + response.getRequestId() + "\n");
//			map.put("data", dataMap);
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//		}
//
//	}
//
//	/**
//	 * 删除视频
//	 *
//	 * @param videoIds
//	 * @return
//	 */
//	@RequestMapping("/deleteVideo")
//	public BaseDto deleteVideo(@RequestParam(value = "videoIds") String videoIds) {
//		return this.videoService.delete(videoIds);
//	}
//
//	/**
//	 * 获取播放地址
//	 *
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/getPlayInfo")
//	public BaseDto getPlayInfo(@RequestParam Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		GetPlayInfoResponse response = new GetPlayInfoResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.getPlayInfo(client, record);
//			List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
////			for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
////				System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
////			}
//			map.put("data", playInfoList);
//			// Base信息
////			System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//		}
//
//	}
//
//	/**
//	 * 获取播放凭证
//	 *
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/getVideoPlayAuth")
//	public BaseDto getVideoPlayAuth(@RequestParam Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.getVideoPlayAuth(client, record.get("videoId"));
//			// 播放凭证
////			System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
//			// VideoMeta信息
////			System.out.print("VideoMeta.Title = " + response.getVideoMeta().getTitle() + "\n");
//			map.put("data", response);
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//		}
//
//	}
//
//	/**
//	 * 提交转码任务
//	 *
//	 * @param record
//	 * @return
//	 */
//	@RequestMapping("/submitTranscodeJobs")
//	public BaseDto submitTranscodeJobs(Map<String, String> record) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "0");
//		DefaultAcsClient client = null;
//		SubmitTranscodeJobsResponse response = new SubmitTranscodeJobsResponse();
//		try {
//			client = VODUtil.initVodClient();
//			response = VODUtil.submitTranscodeJobs(client, record);
//			System.out.println("JobId = " + response.getTranscodeJobs().get(0).getJobId());
//			return new BaseDto(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.reasonPhrase, map);
//		} catch (Exception e) {
//			System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//			return new BaseDto(ResponseCode.EXPECTATION_FAILED.code, ResponseCode.EXPECTATION_FAILED.reasonPhrase, map);
//			// TODO: handle exception
//		}
//
//	}
//
//
//}
