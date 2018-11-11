package ai.remed.clinical.trail.aws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import ai.remed.clinical.trail.aws.lex.request.LexRequest;
import ai.remed.clinical.trail.aws.lex.response.DialogAction;
import ai.remed.clinical.trail.aws.lex.response.LexResponse;
import ai.remed.clinical.trail.aws.lex.response.Message;

public class LambdaFunctionHandler implements RequestHandler<LexRequest, LexResponse> {

	@Override
	public LexResponse handleRequest(LexRequest input, Context context) {
		context.getLogger().log("Input: " + input);
		LexResponse res = new LexResponse();
		DialogAction dialogAction = new DialogAction();
		dialogAction.setType(DialogAction.CLOSE_TYPE);
		dialogAction.setFulfillmentState(DialogAction.FULFILLMENT_STATE_FULFILLED);
		String result = "Found one trail for you: <a href=\"https://clinicaltrials.gov/ct2/show/NCT03146806?cond=cancer&cntry=US&state=US%3AGA&draw=2&rank=14\">Click to open Trail</a>";
		dialogAction.setMessage(new Message(Message.CONTENT_TYPE_PLAIN_TEXT, result));
		res.setDialogAction(dialogAction);
		return res;
	}

}
