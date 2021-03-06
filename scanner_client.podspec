Pod::Spec.new do |spec|
    spec.name                     = 'scanner_client'
    spec.version                  = '0.0.1-SNAPSHOT'
    spec.homepage                 = 'https://github.com/connorf-bbc/scanner-client'
    spec.source                   = { :git => "Not Published", :tag => "Cocoapods/#{spec.name}/#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Scanner Client'

    spec.vendored_frameworks      = "build/cocoapods/framework/scanner_client.framework"
    spec.libraries                = "c++"
    spec.module_name              = "#{spec.name}_umbrella"

    spec.ios.deployment_target = '11.3'

                

    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':',
        'PRODUCT_MODULE_NAME' => 'scanner_client',
    }

    spec.script_phases = [
        {
            :name => 'Build scanner_client',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$COCOAPODS_SKIP_KOTLIN_BUILD" ]; then
                  echo "Skipping Gradle build task invocation due to COCOAPODS_SKIP_KOTLIN_BUILD environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../../../../../private/var/folders/y4/5zhzhd_90xzcjsssv50fl8f40000gn/T/wrap7314loc/gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration=$CONFIGURATION
            SCRIPT
        }
    ]
end