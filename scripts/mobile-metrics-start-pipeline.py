#!/usr/bin/env python3

# Implements https://circleci.com/docs/api/v2/#trigger-a-new-pipeline

import argparse
import os
import requests
import sys

def str2bool(v):
    if isinstance(v, bool):
       return v
    if v.lower() in ('yes', 'true', 't', 'y', '1'):
        return True
    elif v.lower() in ('no', 'false', 'f', 'n', '0'):
        return False
    else:
        raise argparse.ArgumentTypeError('Boolean value expected.')


def TriggerPipeline(slug, token, branch, params):
    url = "https://circleci.com/api/v2/project/github/%s/pipeline" % (slug)

    headers = {
        "Content-Type": "application/json",
        "Accept": "application/json",
    }

    data = {
        "parameters": params
    }
    
    print(data)

    if branch:
        data["branch"] = branch

    r = requests.post(url, auth=(token, ""), headers=headers, json=data)

    if r.status_code != 201 and r.status_code != 200:
        print("Error triggering the CircleCI: %s." % r.json()["message"])
        sys.exit(1)


def Main():
    token = os.getenv("CIRCLE_API_TOKEN")
    username = os.getenv("CIRCLE_PROJECT_USERNAME", default="username")
    project = os.getenv("CIRCLE_PROJECT_REPONAME", default="repository")
    hash = os.getenv("CIRCLE_SHA1", default="1234567890")

    parser = argparse.ArgumentParser(
        description="Creates CircleCI jobs and waits for the result.")

    parser.add_argument("--token", default=token, 
            help="CircleCI token, otherwise environment CIRCLE_API_TOKEN.")
    parser.add_argument("--origin-slug", default="mapbox/mapbox-maps-android",
            help="Origin repository, otherwise CIRCLE_PROJECT_USERNAME/CIRCLE_PROJECT_REPONAME.")
    parser.add_argument("--target-slug", default="".join((username, '/', project)),
            help="Repository to trigger the pipeline, example: mapbox/mapbox-gl-native-android.")
    parser.add_argument("--hash", default=hash,
            help="Commit git hash that triggered the pipeline, otherwise environment CIRCLE_SHA1.")
    parser.add_argument("--branch",
            help="Build a specific branch, otherwise it will build the default branch.")
    parser.add_argument("--mapbox_upstream", default=False,
            help="Build benchmarks, not run on AWS device farm.")

    args = parser.parse_args()

    if not args.token:
        print("CircleCI token not set. Use --token or set CIRCLE_API_TOKEN.")
        sys.exit(1)

    params = {
        "run_android_maps_carbon_benchmark": True,
        "mapbox_upstream_validation": str2bool(args.mapbox_upstream),
        "mapbox_slug": args.origin_slug,
        "mapbox_hash": args.hash
    }

    TriggerPipeline(args.target_slug, args.token, args.branch, params)

    return 0


if __name__ == "__main__":
    Main()