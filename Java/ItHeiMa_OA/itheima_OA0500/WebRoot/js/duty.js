var duty = {
		setting : {
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pid",
				showLine: true,
				root:{ 
					isRoot:true,
					nodes:[]
				}
		},
		loadDutyTree:function() {
			$.ajax({
				url:"dutyAction_showALLDuties.action",
				data:null,
				success:function(data) {
					//alert(data);
					$("#dutyTree").zTree(duty.setting,data);
				}
			});
		}
};


$().ready(function() {
	//���ؽ�ɫ��
	duty.loadDutyTree();
});