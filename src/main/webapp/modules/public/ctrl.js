angular.module('public', ['angularFileUpload'])
    .controller('publicCtrl', ['$scope', '$http', 'FileUploader', '$location', '$routeParams', function ($scope, $http, FileUploader, $location, $routeParams) {

        $('#fileUpload').hide();

        $scope.showUploadWay = function () {
            if ($scope.pic == 1) {
                $('#urlUpload').show();
                $('#fileUpload').hide();
            } else {
                $('#urlUpload').hide();
                $('#fileUpload').show();
            }
        };

        $scope.upload = function () {
            var form = new FormData();
            form.append('file', file, filename)
        };

        var uploader = $scope.uploader = new FileUploader({
            url: 'api/seller/upload_image',
            queueLimit: 1//only can add one item
        });

        uploader.onCompleteItem = function (fileItem, response, status) {
            if (status == 200) {
                $('#imgpre').attr('src', response.result.imageSrc);
                $scope.content.imageSrc = response.result.imageSrc;
                uploader.clearQueue();
                alert("导入成功！");
            } else {
                uploader.clearQueue();
                alert("上传失败！");
            }
        };

        $scope.upload = function () {
            var file = uploader.queue[0].file;
            var size = file.size;
            var name = file.name.toUpperCase();
            if (size > 1000000) {
                alert("图片大小超过限制！");
                uploader.clearQueue();
                return;
            }
            if (name.indexOf("JPG") === -1 && name.indexOf("PNG") === -1 && name.indexOf("JPEG") === -1 && name.indexOf("BMP") === -1) {
                alert("图片格式不支持！");
                uploader.clearQueue();
                return;
            }
            uploader.uploadAll();
        };


        $scope.public = function (content) {

            if (content.title.length < 2 || content.title.length > 80) {
                alert("标题长度必须在2-80字符内！");
                return;
            }
            if (content.summary.length < 2 || content.summary.length > 140) {
                alert("摘要长度必须在2-140字符内！");
                return;
            }
            if (content.detail.length < 2 || content.detail.length > 1000) {
                alert("正文长度必须在2-1000字符内！");
                return;
            }

            //发布新内容
            if (content.id === undefined) {
                $http.post('/api/seller/public', content)
                    .then(function (response) {
                        if (response.status == 200) {
                            $location.path('seller');
                        } else {
                            alert(response.message);
                        }
                    })
            } else {//提交编辑内容
                $http.post('/api/seller/edit', content)
                    .then(function (response) {
                        if (response.status == 200) {
                            $location.path('seller');
                        } else {
                            alert(response.message);
                        }
                    });
            }
        };

        $scope.load = function () {
            if ($routeParams.id !== undefined) {
                $http.get('/api/seller/show_detail?id=' + $routeParams.id)
                    .success(function (data) {
                        $scope.content = data.result;
                    });
            }
        };

        $scope.$watch('content.imageSrc', function (newVal) {
            $('#imgpre').attr('src', newVal);
        });

        $scope.load();

    }]);