#!/bin/bash -xv
#
#	Promote the PUBLISH__BUILD to the downloads 'page'.
#
#    -t PUBLISH__BUILD_TYPE     Build type N/I/S/R, blank suppresses promotion
#    -b PUBLISH__BUILD          The base URL of the build to be published, e.g., https://ci.eclipse.org/uml2/job/mdt-uml2-master/lastSuccessfulBuild
#    -v PUBLISH__VERSION        Unqualified version, e.g., 5.4.0
#    -q PUBLISH__QUALIFIER      Build qualifier, e.g., I20171228-2349
#    -a PUBLISH__ALIAS          Non blank to use alias as part of final name
#
dropsFolder="/home/data/httpd/download.eclipse.org/modeling/mdt/uml2/downloads/drops/"
group="modeling.mdt.uml2"
zipPrefix="mdt-uml2-Update-"

while getopts b:v:t:q:a: option
do
case "${option}"
in
b) PUBLISH__BUILD=${OPTARG};;
v) PUBLISH__VERSION=${OPTARG};;
t) PUBLISH__BUILD_TYPE=${OPTARG};;
q) PUBLISH__QUALIFIER=${OPTARG};;
a) PUBLISH__ALIAS=${OPTARG};;
esac
done

if [ -n "${PUBLISH__BUILD_TYPE}" ]
then

  tQualifier="${PUBLISH__BUILD_TYPE}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  versionFolder="${dropsFolder}${PUBLISH__VERSION}/${tQualifier}"

  if [ ! -d "${versionFolder}" ]
  then
    mkdir -p ${versionFolder}
  fi

  fileStem="${tQualifier}"

  if [ -n "${PUBLISH__ALIAS}" ]
  then
    fileStem=${PUBLISH__ALIAS}
  fi

  zipFile="${zipPrefix}${fileStem}.zip"

  pushd ${versionFolder}
    cp ~/publish.zip ${zipFile}
    cp ~/buildlog.txt buildlog.txt
    md5sum -b ${zipFile} > ${zipFile}.md5
    sha512sum -b ${zipFile} > ${zipFile}.sha1
    # make sure permissions are for the intended group
    chgrp -R ${group} ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
    chmod -R g+w ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
  popd

fi