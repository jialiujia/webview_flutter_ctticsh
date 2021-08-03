#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint webview_flutter_ctticsh.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'webview_flutter_ctticsh'
  s.version          = '0.0.2'
  s.summary          = '独立出来的企业和海事局版的webview_flutter^0.3.24组件'
  s.description      = <<-DESC
独立出来的企业和海事局版的webview_flutter^0.3.24组件
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'
  s.platform = :ios, '8.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
end
