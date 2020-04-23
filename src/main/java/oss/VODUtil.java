package oss;//package oss;
//
//import java.util.Map;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
//import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
//import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
//import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
//import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
//import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
//import com.aliyuncs.vod.model.v20170321.GetVideoInfoRequest;
//import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;
//import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
//import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
//import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoRequest;
//import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
//import com.aliyuncs.vod.model.v20170321.SubmitTranscodeJobsRequest;
//import com.aliyuncs.vod.model.v20170321.SubmitTranscodeJobsResponse;
//
//@Component
//public class VODUtil {
//
//	private static String accessKeyId;
//	private static String accessKeySecret;
//	private static String templateGroupId;
//
//	public static DefaultAcsClient initVodClient() throws ClientException {
//		String regionId = "cn-shanghai"; // 点播服务接入区域
//		DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
//		DefaultAcsClient client = new DefaultAcsClient(profile);
//		return client;
//	}
//
//	/**
//	 * 获取视频上传地址和凭证
//	 *
//	 * @param client 发送请求客户端
//	 * @return CreateUploadVideoResponse 获取视频上传地址和凭证响应数据
//	 * @throws Exception
//	 */
//	public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client, Map<String, String> map)
//			throws Exception {
//		CreateUploadVideoRequest request = new CreateUploadVideoRequest();
//		request.setTitle(map.get("title"));
//		request.setFileName(map.get("filename"));
//		//获取是否转码标识
//		//String transcoding = map.get("transcoding");
//		//如果转码模版ID不为空 同时 转码表示不为空,则转码(添加转码模版)
//		//StringUtils.isNotBlank(transcoding)
//		//有些格式不支持播放,所以强制转码!!!!
//		if ( StringUtils.isNotBlank(templateGroupId)) {
//			request.setTemplateGroupId(templateGroupId);
//		}
//
//		// UserData，用户自定义设置参数，用户需要单独回调URL及数据透传时设置(非必须)
//		// JSONObject userData = new JSONObject();
//		// UserData回调部分设置
//		// JSONObject messageCallback = new JSONObject();
//		// messageCallback.put("CallbackURL", "http://xxxxx");
//		// messageCallback.put("CallbackType", "http");
//		// userData.put("MessageCallback", messageCallback.toJSONString());
//		// UserData透传数据部分设置
//		// JSONObject extend = new JSONObject();
//		// extend.put("MyId", "user-defined-id");
//		// userData.put("Extend", extend.toJSONString());
//		// request.setUserData(userData.toJSONString());
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 刷新视频上传凭证
//	 *
//	 * @param client 发送请求客户端
//	 * @return RefreshUploadVideoResponse 刷新视频上传凭证响应数据
//	 * @throws Exception
//	 */
//	public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient client, Map<String, String> map)
//			throws Exception {
//		RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
//		// VideoId 执行视频上传凭证后返回的VideoId
////		request.setActionName(map.get("Action"));
//		request.setVideoId(map.get("videoId"));
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 删除视频
//	 *
//	 * @param client 发送请求客户端
//	 * @return DeleteVideoResponse 删除视频响应数据
//	 * @throws Exception
//	 */
//	public static DeleteVideoResponse deleteVideo(DefaultAcsClient client, String videoIds) throws Exception {
//		DeleteVideoRequest request = new DeleteVideoRequest();
//		// 支持传入多个视频ID，多个用逗号分隔
//		request.setVideoIds(videoIds);
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 获取播放地址
//	 *
//	 * @param client
//	 * @return
//	 * @throws Exception
//	 */
//	public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client, Map<String, String> map) throws Exception {
//		GetPlayInfoRequest request = new GetPlayInfoRequest();
//		request.setVideoId(map.get("videoId"));
//		request.setDefinition(map.get("definition"));
//		request.setOutputType("oss");
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 获取播放凭证
//	 *
//	 * @param client
//	 * @return
//	 * @throws Exception
//	 */
//	public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client, String videoId) throws Exception {
//		GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
//		request.setVideoId(videoId);
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 获取视频信息
//	 *
//	 * @param client 发送请求客户端
//	 * @return GetVideoInfoResponse 获取视频信息响应数据
//	 * @throws Exception
//	 */
//	public static GetVideoInfoResponse getVideoInfo(DefaultAcsClient client, String videoId) throws Exception {
//		GetVideoInfoRequest request = new GetVideoInfoRequest();
//		request.setVideoId(videoId);
//		return client.getAcsResponse(request);
//	}
//
//	/**
//	 * 提交媒体处理作业
//	 *
//	 * @param client
//	 * @return
//	 * @throws Exception
//	 */
//	public static SubmitTranscodeJobsResponse submitTranscodeJobs(DefaultAcsClient client, Map<String, String> map)
//			throws Exception {
//		SubmitTranscodeJobsRequest request = new SubmitTranscodeJobsRequest();
//		// 需要转码的视频ID
//		request.setVideoId(map.get("videoId"));
//		// 转码模板ID
//		request.setTemplateGroupId(map.get("templateGroupId"));
//		// 构建需要替换的水印参数(只有需要替换水印相关信息才需要构建)
//		// JSONObject overrideParams = buildOverrideParams();
//		// 覆盖参数，暂只支持水印部分参数替换(只有需要替换水印相关信息才需要传递)
//		// request.setOverrideParams(overrideParams.toJSONString());
//		// 构建标准加密配置参数(只有标准加密才需要构建)
//		// JSONObject encryptConfig = buildEncryptConfig(client);
//		// HLS标准加密配置(只有标准加密才需要传递)
//		// request.setEncryptConfig(encryptConfig.toJSONString());
//		return client.getAcsResponse(request);
//	}
//
//	public static String getAccessKeyId() {
//		return accessKeyId;
//	}
//
//	@Value("${accessKeyId}")
//	public void setAccessKeyId(String accessKeyId) {
//		VODUtil.accessKeyId = accessKeyId;
//	}
//
//	public static String getAccessKeySecret() {
//		return accessKeySecret;
//	}
//
//	@Value("${accessKeySecret}")
//	public void setAccessKeySecret(String accessKeySecret) {
//		VODUtil.accessKeySecret = accessKeySecret;
//	}
//
//	public String getTemplateGroupId() {
//		return templateGroupId;
//	}
//
//	@Value("${templateGroupId}")
//	public void setTemplateGroupId(String templateGroupId) {
//		VODUtil.templateGroupId = templateGroupId;
//	}
//
//}
