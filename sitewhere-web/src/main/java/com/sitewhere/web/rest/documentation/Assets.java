/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.web.rest.documentation;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetModule;
import com.sitewhere.rest.model.command.CommandResponse;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.command.CommandResult;
import com.sitewhere.spi.device.IDeviceAssignment;

public class Assets {

	public static class GetAssetModuleResponse extends AssetModule {

		public GetAssetModuleResponse() throws SiteWhereException {
			setId(ExampleData.AM_PERSONS.getId());
			setName(ExampleData.AM_PERSONS.getName());
			setAssetType(ExampleData.AM_PERSONS.getAssetType());
		}
	}

	public static class SearchAssetModuleResponse extends SearchResults<Asset> {

		private static List<Asset> assets = new ArrayList<Asset>();

		static {
			assets.add(ExampleData.ASSET_DEREK);
		}

		public SearchAssetModuleResponse() {
			super(assets);
			setNumResults(1);
		}
	}

	public static class GetAssetByIdPersonResponse extends ExampleData.Person_Derek {

		public GetAssetByIdPersonResponse() {
		}
	}

	public static class GetAssetByIdHardwareResponse extends ExampleData.Hardware_Caterpillar {

		public GetAssetByIdHardwareResponse() {
		}
	}

	public static class GetAssetByIdLocationResponse extends ExampleData.Location_Trailer {

		public GetAssetByIdLocationResponse() {
		}
	}

	public static class GetAssignmentsForAsset extends SearchResults<IDeviceAssignment> {

		private static List<IDeviceAssignment> assignments = new ArrayList<IDeviceAssignment>();

		static {
			assignments.add(ExampleData.TRACKER_TO_DEREK);
			assignments.add(ExampleData.HEART_MONITOR_TO_DEREK);
		}

		public GetAssignmentsForAsset() {
			super(assignments);
			setNumResults(2);
		}
	}

	public static class ListAssetModules {

		public Object generate() throws SiteWhereException {
			List<AssetModule> modules = new ArrayList<AssetModule>();
			modules.add(ExampleData.AM_PERSONS);
			modules.add(ExampleData.AM_DEVICES);
			return modules;
		}
	}

	public static class RefreshAssetModules {

		public Object generate() throws SiteWhereException {
			List<CommandResponse> responses = new ArrayList<CommandResponse>();
			responses.add(new CommandResponse(CommandResult.Successful, "Module loaded successfully."));
			responses.add(new CommandResponse(CommandResult.Failed, "Module failed to refresh."));
			return responses;
		}

	}
}